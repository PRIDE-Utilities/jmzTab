package uk.ac.ebi.pride.jmztab;

import org.apache.commons.cli.*;
import uk.ac.ebi.pride.data.util.MassSpecFileFormat;
import uk.ac.ebi.pride.jmztab.model.MZTabFile;
import uk.ac.ebi.pride.jmztab.model.MZTabUtils;
import uk.ac.ebi.pride.jmztab.utils.MZTabFileConverter;
import uk.ac.ebi.pride.jmztab.utils.MZTabFileParser;
import uk.ac.ebi.pride.jmztab.utils.errors.MZTabErrorList;
import uk.ac.ebi.pride.jmztab.utils.errors.MZTabErrorType;
import uk.ac.ebi.pride.jmztab.utils.errors.MZTabErrorTypeMap;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author qingwei
 * @since 17/09/13
 */
public class MZTabCommandLine {
    public static MassSpecFileFormat getFormat(String format) {
        if (MZTabUtils.isEmpty(format)) {
            return null;
        }

        if (format.equalsIgnoreCase(MassSpecFileFormat.PRIDE.name())) {
            return MassSpecFileFormat.PRIDE;
        } else if (format.equalsIgnoreCase(MassSpecFileFormat.MZIDENTML.name())) {
            return MassSpecFileFormat.MZIDENTML;
        } else {
            return MassSpecFileFormat.PRIDE;
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {
        MZTabErrorTypeMap typeMap = new MZTabErrorTypeMap();

        // Definite command line
        CommandLineParser parser = new PosixParser();
        Options options = new Options();

        String helpOpt = "help";
        options.addOption("h", helpOpt, false, "print help message");

        String msgOpt = "message";
        String codeOpt = "code";
        Option msgOption = OptionBuilder.withArgName(codeOpt)
            .hasArgs(2)
            .withValueSeparator()
            .withDescription("print Error/Warn detail message based on code number.")
            .create(msgOpt);
        options.addOption(msgOption);

        String outOpt = "outFile";
        options.addOption(outOpt, true, "Record error/warn messages into outfile. If not set, print message on the screen. ");

        String checkOpt = "check";
        String inFileOpt = "inFile";
        Option checkOption = OptionBuilder.withArgName(inFileOpt)
            .hasArgs(2)
            .withValueSeparator()
            .withDescription("Choose a file from input directory. This parameter should not be null!")
            .create(checkOpt);
        options.addOption(checkOption);

        String levelOpt = "level";
        options.addOption(levelOpt, true, "Choose validate level(Info, Warn, Error), default level is Error!");

        String convertOpt = "convert";
        String formatOpt = "format";
        Option convertOption = OptionBuilder.withArgName(inFileOpt + ", " + formatOpt)
            .hasArgs()
            .withValueSeparator()
            .withDescription("Converts the given format file (PRIDE or MZIDENTML) to an mztab file.")
            .create(convertOpt);
        options.addOption(convertOption);

        // Parse command line
        CommandLine line = parser.parse(options, args);
        if (line.hasOption(helpOpt)) {
            //HelpFormatter formatter = new HelpFormatter();
            //formatter.printHelp("jmztab", options);
            printHelpHack();
        } else if (line.hasOption(msgOpt)) {
            String[] values = line.getOptionValues(msgOpt);
            Integer code = new Integer(values[1]);
            MZTabErrorType type = typeMap.getType(code);

            if (type == null) {
                System.out.println("Not found MZTabErrorType, the code is :" + code);
            } else {
                System.out.println(type);
            }
        } else {

            File outFile = null;
            if (line.hasOption(outOpt)) {
                outFile = new File(line.getOptionValue(outOpt));
            }

            OutputStream out = outFile == null ? System.out : new BufferedOutputStream(new FileOutputStream(outFile));

            MZTabErrorType.Level level = MZTabErrorType.Level.Error;
            if (line.hasOption(levelOpt)) {
                level = MZTabErrorType.findLevel(line.getOptionValue(levelOpt));
            }

            if (line.hasOption(checkOpt)) {
                String[] values = line.getOptionValues(checkOpt);
                if (values.length != 2) {
                    throw new IllegalArgumentException("Not setting input file!");
                }
                File inFile = new File(values[1].trim());
                System.out.println("Begin check mztab file: " + inFile.getAbsolutePath());
                new MZTabFileParser(inFile, out, level);
            } else if (line.hasOption(convertOpt)) {
                String[] values = line.getOptionValues(convertOpt);
                File inFile = null;
                MassSpecFileFormat format = MassSpecFileFormat.PRIDE;
                for (int i = 0; i < values.length; i++) {
                    String type = values[i++].trim();
                    String value = values[i].trim();
                    if (type.equals(inFileOpt)) {
                        inFile = new File(value.trim());
                    } else if (type.equals(formatOpt)) {
                        format = getFormat(value.trim());
                    }
                }
                if (inFile == null) {
                    throw new IllegalArgumentException("Not setting input file!");
                }

                System.out.println("Begin converting " + inFile.getAbsolutePath() + " which format is " + (format != null ? format.name() : null) + " to mztab file.");
                MZTabFileConverter converter = new MZTabFileConverter(inFile, format);
                MZTabFile tabFile = converter.getMZTabFile();
                MZTabErrorList errorList = converter.getErrorList();

                if (errorList.isEmpty()) {
                    System.out.println("Begin writing mztab file.");
                    tabFile.printMZTab(out);
                } else {
                    System.out.println("There are errors in mztab file.");
                    errorList.print(out);
                }
            }

            System.out.println("Finish!");
            System.out.println();
            out.close();
        }
    }

    /**
     * TODO
     * WARNING - NOTICE We needed the help message coming from the tool to give the user actual working parameters on
     * how to use this command line tool. The problem is that this package is using a really old version of commons-cli
     * from Apache, where OptionBuilder has been deprecated (to my understanding after some time browsing documentation
     * on the internet), and the new versions of commons-cli are in mvnrepository, instead of Maven Central. This means
     * the package needs a lot more detailed/deeper work regarding command line options, thus, having into account that
     * I only need the help message to match the wiki, which contains working instructions, and nothing else is being
     * added to this software in this iteration, plus the fact that we are in the process of reorganizing our maven
     * infrastructure, the problem with apache commons-cli will be addressed later on when either an extension is being
     * implemented or deployment integration works are being carried out on this package regarding our new infrastructure.
     */
    private static void printHelpHack() {
        System.out.println("usage: jmztab\n" +
                " -check inFile=<inFile>                     Choose a file from input directory. This\n" +
                "                                            parameter should not be null!\n" +
                " -convert inFile=<inFile> format=<format>   Converts the given format file (PRIDE or MZIDENTML) to an mztab\n" +
                "                                            file.\n" +
                " -h,--help                                  print help message\n" +
                " -message code=<code>                       print Error/Warn detail message based on code\n" +
                "                                            number.\n" +
                " -outFile <arg>                             Dump output data to the given file. If\n" +
                "                                            not set, output data will be dumped on stdout");
    }

}
