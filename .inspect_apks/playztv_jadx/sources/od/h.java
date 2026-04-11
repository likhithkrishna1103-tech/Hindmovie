package od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends a.a {
    public static final List Q(Object[] objArr) {
        be.h.e(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        be.h.d(listAsList, "asList(...)");
        return listAsList;
    }

    public static void R(int i, int i10, int i11, byte[] bArr, byte[] bArr2) {
        be.h.e(bArr, "<this>");
        be.h.e(bArr2, "destination");
        System.arraycopy(bArr, i10, bArr2, i, i11 - i10);
    }

    public static void S(int i, int i10, int i11, int[] iArr, int[] iArr2) {
        be.h.e(iArr, "<this>");
        be.h.e(iArr2, "destination");
        System.arraycopy(iArr, i10, iArr2, i, i11 - i10);
    }

    public static void T(int i, int i10, int i11, Object[] objArr, Object[] objArr2) {
        be.h.e(objArr, "<this>");
        be.h.e(objArr2, "destination");
        System.arraycopy(objArr, i10, objArr2, i, i11 - i10);
    }

    public static /* synthetic */ void U(int i, int i10, int i11, Object[] objArr, Object[] objArr2) {
        if ((i11 & 4) != 0) {
            i = 0;
        }
        T(0, i, i10, objArr, objArr2);
    }

    public static Object[] V(Object[] objArr, int i, int i10) {
        be.h.e(objArr, "<this>");
        a.a.c(i10, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i10);
        be.h.d(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static void W(Object[] objArr, int i, int i10) {
        be.h.e(objArr, "<this>");
        Arrays.fill(objArr, i, i10, (Object) null);
    }

    public static ArrayList X(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static List Y(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new f(objArr, false)) : android.support.v4.media.session.b.G(objArr[0]) : q.f9570u;
    }
}
