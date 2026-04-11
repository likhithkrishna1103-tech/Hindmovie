package n5;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.versionedparcelable.ParcelImpl;
import b6.f;
import com.google.android.gms.internal.measurement.e;
import com.google.android.gms.internal.measurement.g;
import com.google.android.gms.internal.measurement.k;
import com.google.android.gms.internal.measurement.l;
import com.google.android.gms.internal.measurement.n;
import com.google.android.gms.internal.measurement.r;
import com.google.android.gms.internal.measurement.w;
import d1.q;
import fe.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kf.d0;
import kf.o;
import ne.h;
import pe.x;
import qb.t1;
import v1.m0;
import vd.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static boolean E(Parcel parcel, int i) {
        Q(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int F(Parcel parcel, int i) {
        Q(parcel, i, 4);
        return parcel.readInt();
    }

    public static long G(Parcel parcel, int i) {
        Q(parcel, i, 8);
        return parcel.readLong();
    }

    public static int H(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static final Object J(p pVar) {
        Thread.interrupted();
        return x.o(i.f13722v, new q(pVar, null));
    }

    public static void K(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + H(parcel, i));
    }

    public static int O(Parcel parcel) {
        int i = parcel.readInt();
        int iH = H(parcel, i);
        char c9 = (char) i;
        int iDataPosition = parcel.dataPosition();
        if (c9 != 20293) {
            throw new p8.b("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i))), parcel);
        }
        int i10 = iH + iDataPosition;
        if (i10 >= iDataPosition && i10 <= parcel.dataSize()) {
            return i10;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iDataPosition).length() + 32 + String.valueOf(i10).length());
        sb.append("Size read is invalid start=");
        sb.append(iDataPosition);
        sb.append(" end=");
        sb.append(i10);
        throw new p8.b(sb.toString(), parcel);
    }

    public static String P(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i = 0;
        int i10 = 0;
        while (true) {
            length = objArr.length;
            if (i10 >= length) {
                break;
            }
            Object obj = objArr[i10];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e9) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb.append(name);
                    sb.append("@");
                    sb.append(hexString);
                    String string2 = sb.toString();
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(string2), (Throwable) e9);
                    String name2 = e9.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(name2.length() + string2.length() + 8 + 1);
                    sb2.append("<");
                    sb2.append(string2);
                    sb2.append(" threw ");
                    sb2.append(name2);
                    sb2.append(">");
                    string = sb2.toString();
                }
            }
            objArr[i10] = string;
            i10++;
        }
        StringBuilder sb3 = new StringBuilder(str.length() + (length * 16));
        int i11 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (iIndexOf = str.indexOf("%s", i11)) == -1) {
                break;
            }
            sb3.append((CharSequence) str, i11, iIndexOf);
            sb3.append(objArr[i]);
            i++;
            i11 = iIndexOf + 2;
        }
        sb3.append((CharSequence) str, i11, str.length());
        if (i < length2) {
            sb3.append(" [");
            sb3.append(objArr[i]);
            for (int i12 = i + 1; i12 < objArr.length; i12++) {
                sb3.append(", ");
                sb3.append(objArr[i12]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }

    public static void Q(Parcel parcel, int i, int i10) {
        int iH = H(parcel, i);
        if (iH == i10) {
            return;
        }
        String hexString = Integer.toHexString(iH);
        int length = String.valueOf(i10).length();
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + length + 19 + String.valueOf(iH).length() + 4 + 1);
        sb.append("Expected size ");
        sb.append(i10);
        sb.append(" got ");
        sb.append(iH);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new p8.b(sb.toString(), parcel);
    }

    public static void R(String str, int i, List list) {
        if (list.size() == i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires " + i + " parameters found " + list.size());
    }

    public static void S(Parcel parcel, int i, int i10) {
        if (i == i10) {
            return;
        }
        String hexString = Integer.toHexString(i);
        int length = String.valueOf(i10).length();
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + length + 19 + String.valueOf(i).length() + 4 + 1);
        sb.append("Expected size ");
        sb.append(i10);
        sb.append(" got ");
        sb.append(i);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new p8.b(sb.toString(), parcel);
    }

    public static void T(String str, int i, List list) {
        if (list.size() >= i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at least " + i + " parameters found " + list.size());
    }

    public static void U(String str, int i, ArrayList arrayList) {
        if (arrayList.size() <= i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at most " + i + " parameters found " + arrayList.size());
    }

    public static boolean V(n nVar) {
        if (nVar == null) {
            return false;
        }
        Double d10 = nVar.d();
        return !d10.isNaN() && d10.doubleValue() >= 0.0d && d10.equals(Double.valueOf(Math.floor(d10.doubleValue())));
    }

    public static w W(String str) {
        w wVar = null;
        if (str != null && !str.isEmpty()) {
            wVar = (w) w.G0.get(Integer.valueOf(Integer.parseInt(str)));
        }
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalArgumentException(q4.a.n("Unsupported commandId ", str));
    }

    public static boolean X(n nVar, n nVar2) {
        if (!nVar.getClass().equals(nVar2.getClass())) {
            return false;
        }
        if ((nVar instanceof r) || (nVar instanceof l)) {
            return true;
        }
        if (!(nVar instanceof g)) {
            return nVar instanceof com.google.android.gms.internal.measurement.q ? nVar.i().equals(nVar2.i()) : nVar instanceof e ? nVar.a().equals(nVar2.a()) : nVar == nVar2;
        }
        if (Double.isNaN(nVar.d().doubleValue()) || Double.isNaN(nVar2.d().doubleValue())) {
            return false;
        }
        return nVar.d().equals(nVar2.d());
    }

    public static int Y(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10) || d10 == 0.0d) {
            return 0;
        }
        return (int) ((((double) (d10 > 0.0d ? 1 : -1)) * Math.floor(Math.abs(d10))) % 4.294967296E9d);
    }

    public static double Z(double d10) {
        if (Double.isNaN(d10)) {
            return 0.0d;
        }
        if (Double.isInfinite(d10) || d10 == 0.0d || d10 == 0.0d) {
            return d10;
        }
        return ((double) (d10 > 0.0d ? 1 : -1)) * Math.floor(Math.abs(d10));
    }

    public static td.c a(td.c cVar) {
        cVar.g();
        cVar.f12001x = true;
        return cVar.f12000w > 0 ? cVar : td.c.f11998y;
    }

    public static Object a0(n nVar) {
        if (n.f2537c.equals(nVar)) {
            return null;
        }
        if (n.f2536b.equals(nVar)) {
            return "";
        }
        if (nVar instanceof k) {
            return b0((k) nVar);
        }
        if (!(nVar instanceof com.google.android.gms.internal.measurement.d)) {
            return !nVar.d().isNaN() ? nVar.d() : nVar.i();
        }
        ArrayList arrayList = new ArrayList();
        com.google.android.gms.internal.measurement.d dVar = (com.google.android.gms.internal.measurement.d) nVar;
        int i = 0;
        while (i < dVar.m()) {
            if (i >= dVar.m()) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
                sb.append("Out of bounds index: ");
                sb.append(i);
                throw new NoSuchElementException(sb.toString());
            }
            int i10 = i + 1;
            Object objA0 = a0(dVar.n(i));
            if (objA0 != null) {
                arrayList.add(objA0);
            }
            i = i10;
        }
        return arrayList;
    }

    public static HashMap b0(k kVar) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList(kVar.f2501v.keySet());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            Object objA0 = a0(kVar.b(str));
            if (objA0 != null) {
                map.put(str, objA0);
            }
        }
        return map;
    }

    public static void c(String str, long j4) {
        if (j4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " (" + j4 + ") must be >= 0");
    }

    public static void c0(f fVar) {
        int iY = Y(fVar.A("runtime.counter").d().doubleValue() + 1.0d);
        if (iY > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        fVar.y("runtime.counter", new g(Double.valueOf(iY)));
    }

    public static final void f(o oVar, String str, String str2) {
        ge.i.e(str, "name");
        ge.i.e(str2, "value");
        ArrayList arrayList = oVar.f7512a;
        arrayList.add(str);
        arrayList.add(h.t0(str2).toString());
    }

    public static Bundle g(Parcel parcel, int i) {
        int iH = H(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iH);
        return bundle;
    }

    public static td.c h() {
        return new td.c(10);
    }

    public static Parcelable i(Parcel parcel, int i, Parcelable.Creator creator) {
        int iH = H(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iH);
        return parcelable;
    }

    public static String j(Parcel parcel, int i) {
        int iH = H(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iH);
        return string;
    }

    public static Object[] k(Parcel parcel, int i, Parcelable.Creator creator) {
        int iH = H(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iH);
        return objArrCreateTypedArray;
    }

    public static ArrayList l(Parcel parcel, int i, Parcelable.Creator creator) {
        int iH = H(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iH);
        return arrayListCreateTypedArrayList;
    }

    public static void m(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 26);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new p8.b(sb.toString(), parcel);
    }

    public static kf.n n(SSLSession sSLSession) throws IOException {
        Object objJ;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") || cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException("cipherSuite == ".concat(cipherSuite));
        }
        kf.h hVarB = kf.h.f7464b.b(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        d0.f7455w.getClass();
        d0 d0VarC = kf.b.c(protocol);
        try {
            objJ = lf.f.j(sSLSession.getPeerCertificates());
        } catch (SSLPeerUnverifiedException unused) {
            objJ = sd.p.f11669v;
        }
        return new kf.n(d0VarC, hVarB, lf.f.j(sSLSession.getLocalCertificates()), new c.d0(7, objJ));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class o(le.b bVar) {
        ge.i.e(bVar, "<this>");
        Class clsA = ((ge.e) bVar).a();
        if (clsA.isPrimitive()) {
            String name = clsA.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsA;
    }

    public static SharedPreferences p(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    public static d q(Bundle bundle) {
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable("android.support.v4.media.session.SESSION_TOKEN2");
            if (bundle2 == null) {
                return null;
            }
            bundle2.setClassLoader(a.class.getClassLoader());
            Parcelable parcelable = bundle2.getParcelable("a");
            if (parcelable instanceof ParcelImpl) {
                return ((ParcelImpl) parcelable).f1487v;
            }
            throw new IllegalArgumentException("Invalid parcel");
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static final void t(String str) {
        ge.i.e(str, "name");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('!' > cCharAt || cCharAt >= 127) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                t1.b(16);
                String string = Integer.toString(cCharAt, 16);
                ge.i.d(string, "toString(...)");
                if (string.length() < 2) {
                    string = "0".concat(string);
                }
                sb.append(string);
                sb.append(" at ");
                sb.append(i);
                sb.append(" in header name: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static final void u(String str, String str2) {
        ge.i.e(str, "value");
        ge.i.e(str2, "name");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                t1.b(16);
                String string = Integer.toString(cCharAt, 16);
                ge.i.d(string, "toString(...)");
                if (string.length() < 2) {
                    string = "0".concat(string);
                }
                sb.append(string);
                sb.append(" at ");
                sb.append(i);
                sb.append(" in ");
                sb.append(str2);
                sb.append(" value");
                sb.append(lf.d.j(str2) ? "" : ": ".concat(str));
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static int v(String str) {
        if (str == null) {
            return -1;
        }
        String strP = m0.p(str);
        strP.getClass();
        switch (strP) {
        }
        return -1;
    }

    public static int w(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        if (lastPathSegment.endsWith(".avi")) {
            return 16;
        }
        if (lastPathSegment.endsWith(".png")) {
            return 17;
        }
        if (lastPathSegment.endsWith(".webp")) {
            return 18;
        }
        if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
            return 19;
        }
        if (lastPathSegment.endsWith(".heic") || lastPathSegment.endsWith(".heif")) {
            return 20;
        }
        return lastPathSegment.endsWith(".avif") ? 21 : -1;
    }

    public static List x(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        ge.i.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public abstract void B(int i);

    public abstract void C(View view, int i, int i10);

    public abstract void D(View view, float f, float f10);

    public abstract void L();

    public abstract void M();

    public abstract boolean N(View view, int i);

    public boolean b() {
        return false;
    }

    public abstract int d(View view, int i);

    public abstract int e(View view, int i);

    public int r(View view) {
        return 0;
    }

    public int s() {
        return 0;
    }

    public void I() {
    }

    public void z() {
    }

    public void A(View view, int i) {
    }

    public void y(int i, int i10) {
    }
}
