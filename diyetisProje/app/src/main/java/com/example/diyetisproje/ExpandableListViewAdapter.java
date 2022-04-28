package com.example.diyetisproje;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {



    private Context context;
    private List<String> chapterList;
    private HashMap<String, List<String>> topicsList;

    public ExpandableListViewAdapter(Context context, List<String> chapterList, HashMap<String, List<String>> topicsList) {
        this.context = context;
        this.chapterList = chapterList;
        this.topicsList = topicsList;
    }


    @Override
    public int getGroupCount() {
        return this.chapterList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.topicsList.get(this.chapterList.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.chapterList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.topicsList.get(this.chapterList.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String chapterTitle=(String) getGroup(i);
        if (view==null)
        {
            LayoutInflater inflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.expandlistitem,null);
        }
        TextView expandlist=view.findViewById(R.id.mobilelist);
        expandlist.setText(chapterTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String topicTitle=(String) getChild(i,i1);
        if (view==null)
        {
            LayoutInflater inflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.expachilditem,null);
        }
        TextView topicTit=view.findViewById(R.id.model);
        topicTit.setText(topicTitle);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
