package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.api.story.IMasterStore;
import com.senlaCourse.autoservice.entity.Master;

import java.util.ArrayList;
import java.util.List;

public class MasterStoreImpl implements IMasterStore {

    private List<Master> masters = new ArrayList<Master>();

    @Override
    public void delete(Master master) {
        {
            int index = 0;
            boolean flag = false;
            for (int i=0; i<masters.size(); i++){
                if (masters.get(i).getName().equals(master.getName()) ){
                    flag = true;
                    index = i;
                    break;
                }
            }
            if (flag) {
                masters.remove(index);
            }
            else {
                System.out.println("You cannot delete this element!");
            }
        }
    }

    @Override
    public void add(Master master) {
        masters.add(master);
    }

    @Override
    public List<Master> getAll() {
        return masters;
    }

}
