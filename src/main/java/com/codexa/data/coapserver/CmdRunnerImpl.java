package com.codexa.data.coapserver;


import com.codexa.data.coapserver.api.CmdRunner;
import com.codexa.data.coapserver.api.CoapDataSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by peter on 26.7.2017.
 */
@Service
public class CmdRunnerImpl implements CmdRunner {

    private Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private CoapDataSender coapDataSender;



    @Override
    public void writeGeneratedCoapData(Integer messageCount) {

        int availableCpus = Runtime.getRuntime().availableProcessors();
        log.info(String.format("Generate coap messages is going to use %d cpus/cores.", availableCpus));

        for (int i = 0; i < availableCpus; i++) {

            coapDataSender.sendSensorMessage(messageCount);
        }
        log.info("generating is over");
    }
}