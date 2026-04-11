package ce;

import com.bumptech.glide.f;
import ge.i;
import java.io.File;
import ne.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends f {
    public static String M(File file) {
        String name = file.getName();
        i.d(name, "getName(...)");
        int iM0 = h.m0(name, ".");
        if (iM0 == -1) {
            return name;
        }
        String strSubstring = name.substring(0, iM0);
        i.d(strSubstring, "substring(...)");
        return strSubstring;
    }
}
