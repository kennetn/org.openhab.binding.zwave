/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.zwave.internal.protocol.commandclass.impl;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_MANUFACTURER_PROPRIETARY_FIBARO_FGRM222</b> version
 * <b>1</b>.
 * <p>
 * Command Class Manufacturer Proprietary [Fibaro FGRM-222]
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x91.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassManufacturerProprietaryFibaroFgrm222V1 {
    private static final Logger logger = LoggerFactory
            .getLogger(CommandClassManufacturerProprietaryFibaroFgrm222V1.class);

    /**
     * Integer command class key for COMMAND_CLASS_MANUFACTURER_PROPRIETARY_FIBARO_FGRM222
     */
    public final static int COMMAND_CLASS_KEY = 0x91;

    /**
     * Set shutter or lamella position Command Constant
     */
    public final static int FGRM222_SET = 0x01;
    /**
     * Get blinds and Lamella position Command Constant
     */
    public final static int FGRM222_GET = 0x02;
    /**
     * Blinds and Lamella position report Command Constant
     */
    public final static int FGRM222_REPORT = 0x03;

    /**
     * Map holding constants for Fgrm222ReportConstant1
     */
    private static Map<Integer, String> constantFgrm222ReportConstant1 = new HashMap<Integer, String>();

    /**
     * Map holding constants for Fgrm222SetCommand
     */
    private static Map<Integer, String> constantFgrm222SetCommand = new HashMap<Integer, String>();

    /**
     * Map holding constants for Fgrm222ReportConstant2
     */
    private static Map<Integer, String> constantFgrm222ReportConstant2 = new HashMap<Integer, String>();

    /**
     * Map holding constants for Fgrm222ReportConstant3
     */
    private static Map<Integer, String> constantFgrm222ReportConstant3 = new HashMap<Integer, String>();

    /**
     * Map holding constants for Fgrm222SetConstant1
     */
    private static Map<Integer, String> constantFgrm222SetConstant1 = new HashMap<Integer, String>();

    /**
     * Map holding constants for Fgrm222SetConstant3
     */
    private static Map<Integer, String> constantFgrm222SetConstant3 = new HashMap<Integer, String>();

    /**
     * Map holding constants for Fgrm222SetConstant2
     */
    private static Map<Integer, String> constantFgrm222SetConstant2 = new HashMap<Integer, String>();
    static {

        // Constants for Fgrm222ReportConstant1

        // Constants for Fgrm222SetCommand
        constantFgrm222SetCommand.put(0x01, "LAMELLA_POSITION");
        constantFgrm222SetCommand.put(0x02, "SHUTTER_POSITION");

        // Constants for Fgrm222ReportConstant2

        // Constants for Fgrm222ReportConstant3

        // Constants for Fgrm222SetConstant1

        // Constants for Fgrm222SetConstant3

        // Constants for Fgrm222SetConstant2
    }

    /**
     * Creates a new message with the FGRM222_SET command.
     * <p>
     * Set shutter or lamella position
     *
     * @param command {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>LAMELLA_POSITION
     *            <li>SHUTTER_POSITION
     *            </ul>
     * @param shutterPosition {@link Integer}
     * @param lamellaPosition {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFgrm222Set(String command, Integer shutterPosition, Integer lamellaPosition) {
        logger.debug("Creating command message FGRM222_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FGRM222_SET);

        // Process 'Constant1'
        outputData.write(0x0F);

        // Process 'Constant2'
        outputData.write(0x26);

        // Process 'Constant3'
        outputData.write(0x01);

        // Process 'Command'
        boolean foundCommand = false;
        for (Integer entry : constantFgrm222SetCommand.keySet()) {
            if (constantFgrm222SetCommand.get(entry).equals(command)) {
                outputData.write(entry);
                foundCommand = true;
                break;
            }
        }
        if (!foundCommand) {
            throw new IllegalArgumentException("Unknown constant value '" + command + "' for command");
        }

        // Process 'Shutter Position'
        outputData.write(shutterPosition);

        // Process 'Lamella Position'
        outputData.write(lamellaPosition);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FGRM222_SET command.
     * <p>
     * Set shutter or lamella position
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>COMMAND {@link String}
     * <li>SHUTTER_POSITION {@link Integer}
     * <li>LAMELLA_POSITION {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFgrm222Set(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Constant1'

        // Process 'Constant2'

        // Process 'Constant3'

        // Process 'Command'
        response.put("COMMAND", constantFgrm222SetCommand.get(payload[5] & 0xff));

        // Process 'Shutter Position'
        response.put("SHUTTER_POSITION", Integer.valueOf(payload[6]));

        // Process 'Lamella Position'
        response.put("LAMELLA_POSITION", Integer.valueOf(payload[7]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the FGRM222_GET command.
     * <p>
     * Get blinds and Lamella position
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFgrm222Get() {
        logger.debug("Creating command message FGRM222_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FGRM222_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FGRM222_GET command.
     * <p>
     * Get blinds and Lamella position
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFgrm222Get(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the FGRM222_REPORT command.
     * <p>
     * Blinds and Lamella position report
     *
     * @param shutterPosition {@link Integer}
     * @param lamellaPosition {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFgrm222Report(Integer shutterPosition, Integer lamellaPosition) {
        logger.debug("Creating command message FGRM222_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FGRM222_REPORT);

        // Process 'Constant1'
        outputData.write(0x0F);

        // Process 'Constant2'
        outputData.write(0x26);

        // Process 'Constant3'
        outputData.write(0x01);

        // Process 'Reserved4'
        outputData.write(0);

        // Process 'Shutter Position'
        outputData.write(shutterPosition);

        // Process 'Lamella Position'
        outputData.write(lamellaPosition);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FGRM222_REPORT command.
     * <p>
     * Blinds and Lamella position report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>SHUTTER_POSITION {@link Integer}
     * <li>LAMELLA_POSITION {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFgrm222Report(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Constant1'

        // Process 'Constant2'

        // Process 'Constant3'

        // Process 'Shutter Position'
        response.put("SHUTTER_POSITION", Integer.valueOf(payload[6]));

        // Process 'Lamella Position'
        response.put("LAMELLA_POSITION", Integer.valueOf(payload[7]));

        // Return the map of processed response data;
        return response;
    }

}
