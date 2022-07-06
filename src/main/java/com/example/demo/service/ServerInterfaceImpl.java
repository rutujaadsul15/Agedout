package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class ServerInterfaceImpl implements ServerInterface {
    @Override
    public void findOdn() {

        List<String> serverList = getServerList();
        for (int i = 0; i < serverList.size(); i++) {

            String url = "https://odin.in.here.com/rest/GlobalSearch?_dc=1652442011230&quicksearch=" + serverList.get(i) + "&_page=1&_start=0&_limit=1000&_group=%7B%22property%22%3A%22_object%22%2C%22direction%22%3A%22ASC%22%7D";

            HttpURLConnection httpClient =
                    null;
            try {
                httpClient = (HttpURLConnection) new URL(url).openConnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // optional default is GET
            try {
                httpClient.setRequestMethod("GET");
            } catch (ProtocolException e) {
                throw new RuntimeException(e);
            }
            //add request header
            httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");

            httpClient.setRequestProperty("Cookie", "_gcl_au=1.1.78591599.1648472253; _mkto_trk=id:307-QLA-991&token:_mch-here.com-1648472256043-65329; sessionid=o6helqby9engrhy1u5bsl1ysd2a7jsvv");

            int responseCode = 0;
            try {
                responseCode = httpClient.getResponseCode();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpClient.getInputStream()))) {

                StringBuilder response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                ObjectMapper mapper = new ObjectMapper();
                try {
                    JsonNode node = mapper.readTree(response.toString());
                    String exist = String.valueOf(node.get("data").get(0).get("agedout"));
                    if (exist.equalsIgnoreCase("false"))
                        System.out.println(serverList.get(i) + " " + "No");
                    else
                        System.out.println(serverList.get(i) + " " + "Yes");
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finished.............");
    }


    public List<String> getServerList() {
        return Arrays.asList(

                "pamsspccs02.lnx.in.here.com",
                "patlspccs02.lnx.in.here.com",
                "datlspcca01.lnx.in.here.com",
                "datlspccd01.lnx.in.here.com",
                "damsspcca01.lnx.in.here.com",
                "damshcsprov01.lnx.in.here.com",
                "datlhcsprov03.lnx.in.here.com",
                "damshcsprov02.lnx.in.here.com",
                "datlhcssigner01.lnx.in.here.com",
                "damshcscadb01.lnx.in.here.com",
                "datlhcscadb01.lnx.in.here.com",
                "damsspccd01.lnx.in.here.com",
                "pamsspccs05.lnx.in.here.com",
                "datlhcsslog01.lnx.in.here.com",
                "datlhcsprovcache01.lnx.in.here.com",
                "datlhcsprov01.lnx.in.here.com",
                "patlspccs01.lnx.in.here.com",
                "datlhcsxmlsign.lnx.in.here.com",
                "datlhcsprov02.lnx.in.here.com",
                "patlspcc05.lnx.in.here.com",
                "patlspccs05.lnx.in.here.com",
                "patlspccs06.lnx.in.here.com"
                );
    }
}
