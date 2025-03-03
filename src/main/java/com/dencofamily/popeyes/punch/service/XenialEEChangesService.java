package com.dencofamily.popeyes.punch.service;

import com.dencofamily.popeyes.punch.dao.XenialEEChangesDao;
import com.dencofamily.popeyes.punch.model.XenialEEChanges;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class XenialEEChangesService {

    private final XenialEEChangesDao xenialEEChangesDao;

    public XenialEEChangesService(XenialEEChangesDao xenialEEChangesDao) {
        this.xenialEEChangesDao = xenialEEChangesDao;
    }
//
//    public List<XenialEEChanges> getAllChanges() {
//        return xenialEEChangesDao.getAllChanges();
//    }
//    public List<XenialEEChanges> getAllChanges() {
//        List<XenialEEChanges> changes = xenialEEChangesDao.getAllChanges();
//        for (XenialEEChanges change : changes) {
//            if (change.getSiteId() != null && change.getSiteId().contains(" - ")) {
//                change.setSiteId(change.getSiteId().substring(change.getSiteId().lastIndexOf(" - ") + 3));
//            }
//        }
//        return changes;
//    }
    public List<XenialEEChanges> getAllChanges() {
        List<XenialEEChanges> changes = xenialEEChangesDao.getAllChanges();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        for (XenialEEChanges change : changes) {
            // Format SiteId
            if (change.getSiteId() != null) {
                Pattern pattern = Pattern.compile("(\\d+)-"); // Matches last numeric value before '-'
                Matcher matcher = pattern.matcher(change.getSiteId());

                if (matcher.find()) {
                    change.setSiteId(matcher.group(1)); // Set only the matched numeric site ID
                }
            }


            // Convert and Format changeTime (if not null)
            if (change.getChangeTime() != null) {
                OffsetDateTime dateTime = OffsetDateTime.parse(change.getChangeTime()); // Parses the Zoned DateTime
                change.setChangeTime(dateTime.format(formatter)); // Format to MM/dd/yyyy
            }
        }
        return changes;
    }

}
