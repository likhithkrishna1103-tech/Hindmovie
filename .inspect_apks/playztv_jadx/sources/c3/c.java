package c3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f2450w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long[] f2451x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long[] f2452y;

    public static Serializable q1(int i, u uVar) {
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(uVar.r()));
        }
        if (i == 1) {
            return Boolean.valueOf(uVar.x() == 1);
        }
        if (i == 2) {
            return s1(uVar);
        }
        if (i != 3) {
            if (i == 8) {
                return r1(uVar);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) Double.longBitsToDouble(uVar.r()));
                uVar.K(2);
                return date;
            }
            int iB = uVar.B();
            ArrayList arrayList = new ArrayList(iB);
            for (int i10 = 0; i10 < iB; i10++) {
                Serializable serializableQ1 = q1(uVar.x(), uVar);
                if (serializableQ1 != null) {
                    arrayList.add(serializableQ1);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strS1 = s1(uVar);
            int iX = uVar.x();
            if (iX == 9) {
                return map;
            }
            Serializable serializableQ12 = q1(iX, uVar);
            if (serializableQ12 != null) {
                map.put(strS1, serializableQ12);
            }
        }
    }

    public static HashMap r1(u uVar) {
        int iB = uVar.B();
        HashMap map = new HashMap(iB);
        for (int i = 0; i < iB; i++) {
            String strS1 = s1(uVar);
            Serializable serializableQ1 = q1(uVar.x(), uVar);
            if (serializableQ1 != null) {
                map.put(strS1, serializableQ1);
            }
        }
        return map;
    }

    public static String s1(u uVar) {
        int iD = uVar.D();
        int i = uVar.f11710b;
        uVar.K(iD);
        return new String(uVar.f11709a, i, iD);
    }
}
