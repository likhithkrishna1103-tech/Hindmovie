package g3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a7.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f4973x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long[] f4974y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long[] f4975z;

    public static Serializable n1(int i, t tVar) {
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(tVar.r()));
        }
        if (i == 1) {
            return Boolean.valueOf(tVar.x() == 1);
        }
        if (i == 2) {
            return p1(tVar);
        }
        if (i != 3) {
            if (i == 8) {
                return o1(tVar);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) Double.longBitsToDouble(tVar.r()));
                tVar.K(2);
                return date;
            }
            int iB = tVar.B();
            ArrayList arrayList = new ArrayList(iB);
            for (int i10 = 0; i10 < iB; i10++) {
                Serializable serializableN1 = n1(tVar.x(), tVar);
                if (serializableN1 != null) {
                    arrayList.add(serializableN1);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strP1 = p1(tVar);
            int iX = tVar.x();
            if (iX == 9) {
                return map;
            }
            Serializable serializableN12 = n1(iX, tVar);
            if (serializableN12 != null) {
                map.put(strP1, serializableN12);
            }
        }
    }

    public static HashMap o1(t tVar) {
        int iB = tVar.B();
        HashMap map = new HashMap(iB);
        for (int i = 0; i < iB; i++) {
            String strP1 = p1(tVar);
            Serializable serializableN1 = n1(tVar.x(), tVar);
            if (serializableN1 != null) {
                map.put(strP1, serializableN1);
            }
        }
        return map;
    }

    public static String p1(t tVar) {
        int iD = tVar.D();
        int i = tVar.f14610b;
        tVar.K(iD);
        return new String(tVar.f14609a, i, iD);
    }
}
