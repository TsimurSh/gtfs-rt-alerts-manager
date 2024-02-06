package pl.goeuropa.goeuropaservicealerts.service;

import com.google.transit.realtime.GtfsRealtime;
import com.google.transit.realtime.GtfsRealtime.Alert.*;
import com.google.transit.realtime.GtfsRealtime.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.google.transit.realtime.GtfsRealtime.FeedEntity.newBuilder;
import static pl.goeuropa.goeuropaservicealerts.model.serviceAlerts.ServiceAlertBuilderHelper.fillTranslations;

@Slf4j
@Service
public class AlertServiceImpl implements AlertService {


    @Override
    public Builder createAlert(Cause cause, Effect effect) {

   FeedMessage.Builder feedMessageBuilder = FeedMessage.newBuilder();
        // Create an Alert builder
        Builder alertBuilder = Alert.newBuilder();
        GtfsRealtime.FeedEntity.Builder entity = feed.addEntityBuilder();

        entity.setId(Integer.toString(feed.getEntityCount()));
        GtfsRealtime.Alert.Builder alert = entity.getAlertBuilder();

        fillTranslations(serviceAlert.getSummaries(),
                alert.getHeaderTextBuilder());
        fillTranslations(serviceAlert.getDescriptions(),
                alert.getDescriptionTextBuilder());
        fillTranslations(serviceAlert.getUrls(),
                alert.getUrlBuilder());
        alertBuilder.setCause(cause).setEffect(effect);


        // Create an instance of ActivePeriod for the time range
        TimeRange.Builder timeRangeBuilder = TimeRange.newBuilder();

        // Set start and end times for the active period
        timeRangeBuilder.setStart(1234567890L).setEnd(1234567899L);
        alertBuilder.addActivePeriod(timeRangeBuilder.build());

        // Add the Alert to the FeedMessage
        feedMessageBuilder.addEntity(newBuilder().setAlert(alertBuilder));
        feedMessageBuilder.addEntity(newBuilder().setAlert(alertBuilder));
        feedMessageBuilder.addEntity(newBuilder().setAlert(alertBuilder));
        feedMessageBuilder.addEntity(newBuilder().setAlert(alertBuilder));

        // Serialize the FeedMessage
        byte[] serializedFeed = feedMessageBuilder.build().toByteArray();

        // Now you can send the serializedFeed to the real-time data server
        // (The specific method of sending data depends on your implementation)

        // Export the serialized feed to a .pb file
//        try (FileOutputStream file = new FileOutputStream("output.pb")) {
//            file.write(serializedFeed);
//            System.out.println("Serialized GTFS-realtime feed exported to output.pb");
//        } catch (IOException e) {
//            e.printStackTrace();
        return alertBuilder;
    }
}
