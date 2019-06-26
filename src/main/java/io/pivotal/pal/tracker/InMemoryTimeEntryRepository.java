package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private long currentId = 1L;
    HashMap<Long,TimeEntry> timeEntry_HashMap = new HashMap();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = currentId++;
        TimeEntry timeEntry_temp= new TimeEntry();
        timeEntry_temp.setId(id);
        timeEntry_temp.setDate(timeEntry.getDate());
        timeEntry_temp.setHours(timeEntry.getHours());
        timeEntry_temp.setProjectId(timeEntry.getProjectId());
        timeEntry_temp.setUserId(timeEntry.getUserId());
        timeEntry_HashMap.put(timeEntry_temp.getId(),timeEntry_temp);
    return timeEntry_temp;
    }

    @Override
    public TimeEntry find(Long id) {
        if (timeEntry_HashMap.containsKey(id))
            return timeEntry_HashMap.get(id);
       else {
            return null;
        }
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntry_HashMap.values());
    }
    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if (timeEntry_HashMap.containsKey(id)){
     /*   TimeEntry timeEntry_update= new TimeEntry();
        timeEntry_update.setId();
        timeEntry_update.setDate(timeEntry.getDate());
        timeEntry_update.setHours(timeEntry.getHours());
        timeEntry_update.setProjectId(timeEntry.getProjectId());
        timeEntry.setUserId(timeEntry_update.getUserId());*/
     timeEntry.setId(id);
            timeEntry_HashMap.replace(id,timeEntry);
            return timeEntry_HashMap.get(id);
        }
        else
            return null;
    }

    @Override
    public void delete(Long id) {
        timeEntry_HashMap.remove(id);

    }
}
