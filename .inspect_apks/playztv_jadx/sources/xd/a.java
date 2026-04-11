package xd;

import be.h;
import ie.e;
import java.io.File;
import q1.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends c {
    public static String Y(File file) {
        String name = file.getName();
        h.d(name, "getName(...)");
        int iW = e.W(name, ".");
        if (iW == -1) {
            return name;
        }
        String strSubstring = name.substring(0, iW);
        h.d(strSubstring, "substring(...)");
        return strSubstring;
    }
}
