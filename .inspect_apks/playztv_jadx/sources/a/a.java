package a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.e0;
import be.h;
import com.bumptech.glide.d;
import g4.i;
import ga.g;
import ie.n;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import ka.b;
import ka.c;
import ke.r;
import od.t;
import pe.f;
import ta.j;
import zc.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final boolean A(Context context) {
        NetworkCapabilities networkCapabilities;
        h.e(context, "<this>");
        Object systemService = context.getSystemService("connectivity");
        h.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        return activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dd A[PHI: r8
      0x00dd: PHI (r8v22 java.lang.String) = (r8v21 java.lang.String), (r8v34 java.lang.String) binds: [B:46:0x00c5, B:50:0x00d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void B(android.content.Intent r22) {
        /*
            Method dump skipped, instruction units count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.B(android.content.Intent):void");
    }

    public static void C(String str, Bundle bundle) {
        try {
            g.c();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String string = bundle.getString("google.c.a.c_id");
            if (string != null) {
                bundle2.putString("_nmid", string);
            }
            String string2 = bundle.getString("google.c.a.c_l");
            if (string2 != null) {
                bundle2.putString("_nmn", string2);
            }
            String string3 = bundle.getString("google.c.a.m_l");
            if (!TextUtils.isEmpty(string3)) {
                bundle2.putString("label", string3);
            }
            String string4 = bundle.getString("google.c.a.m_c");
            if (!TextUtils.isEmpty(string4)) {
                bundle2.putString("message_channel", string4);
            }
            String string5 = bundle.getString("from");
            if (string5 == null || !string5.startsWith("/topics/")) {
                string5 = null;
            }
            if (string5 != null) {
                bundle2.putString("_nt", string5);
            }
            String string6 = bundle.getString("google.c.a.ts");
            if (string6 != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(string6));
                } catch (NumberFormatException e10) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e10);
                }
            }
            String string7 = bundle.containsKey("google.c.a.udt") ? bundle.getString("google.c.a.udt") : null;
            if (string7 != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(string7));
                } catch (NumberFormatException e11) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e11);
                }
            }
            String str2 = j.g(bundle) ? "display" : "data";
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", str2);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Logging to scion event=" + str + " scionPayload=" + bundle2);
            }
            b bVar = (b) g.c().b(b.class);
            if (bVar != null) {
                ((c) bVar).a("fcm", str, bundle2);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    public static final void J(int i, int i10, String str) {
        h.e(str, "fileTempDir");
        try {
            String strO = o(str, i);
            long j5 = i10;
            h.e(strO, "filePath");
            File fileV = android.support.v4.media.session.b.v(strO);
            if (fileV.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileV, "rw");
                try {
                    randomAccessFile.seek(0L);
                    randomAccessFile.setLength(0L);
                    randomAccessFile.writeLong(j5);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused3) {
        }
    }

    public static void K(Window window, boolean z2) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            j0.b.d(window, z2);
        } else {
            if (i >= 30) {
                j0.b.c(window, z2);
                return;
            }
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z2 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    public static void L(Outline outline, Path path) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            e9.b.a(outline, path);
            return;
        }
        if (i >= 29) {
            try {
                e9.a.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            e9.a.a(outline, path);
        }
    }

    public static boolean M(Intent intent) {
        Bundle extras;
        if (intent == null || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
            return false;
        }
        return "1".equals(extras.getString("google.c.a.e"));
    }

    public static final long N(int i, je.c cVar) {
        h.e(cVar, "unit");
        if (cVar.compareTo(je.c.SECONDS) > 0) {
            return O(i, cVar);
        }
        long jK = android.support.v4.media.session.b.k(i, cVar, je.c.NANOSECONDS) << 1;
        int i10 = je.a.f6958x;
        int i11 = je.b.f6960a;
        return jK;
    }

    public static final long O(long j5, je.c cVar) {
        h.e(cVar, "unit");
        je.c cVar2 = je.c.NANOSECONDS;
        long jK = android.support.v4.media.session.b.k(4611686018426999999L, cVar2, cVar);
        if ((-jK) > j5 || j5 > jK) {
            je.c cVar3 = je.c.MILLISECONDS;
            h.e(cVar3, "targetUnit");
            return g(ga.b.d(cVar3.f6966u.convert(j5, cVar.f6966u)));
        }
        long jK2 = android.support.v4.media.session.b.k(j5, cVar, cVar2) << 1;
        int i = je.a.f6958x;
        int i10 = je.b.f6960a;
        return jK2;
    }

    public static final void c(int i, int i10) {
        if (i <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i10 + ").");
    }

    public static final void d(String str, int i) {
        File[] fileArrListFiles;
        h.e(str, "fileTempDir");
        try {
            File file = new File(str);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            for (File file2 : fileArrListFiles) {
                h.b(file2);
                if (n.M(xd.a.Y(file2), i + ".", false)) {
                    arrayList.add(file2);
                }
            }
            int size = arrayList.size();
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                File file3 = (File) obj;
                if (file3.exists()) {
                    file3.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static boolean e() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            g.c();
            g gVarC = g.c();
            gVarC.a();
            Context context = gVarC.f5346a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    public static void f(g4.j jVar) {
        try {
            i iVar = (i) jVar;
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                parcelObtain.writeInt(0);
                iVar.f5084d.transact(3006, parcelObtain, null, 1);
            } finally {
                parcelObtain.recycle();
            }
        } catch (RemoteException unused) {
        }
    }

    public static final long g(long j5) {
        long j8 = (j5 << 1) + 1;
        int i = je.a.f6958x;
        int i10 = je.b.f6960a;
        return j8;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0092 A[EDGE_INSN: B:45:0x0092->B:41:0x0092 BREAK  A[LOOP:0: B:11:0x001a->B:49:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List h(n.a1 r9, int r10, int r11) {
        /*
            java.lang.String r0 = "<this>"
            be.h.e(r9, r0)
            java.lang.Object r9 = r9.f8343u
            java.util.LinkedHashMap r9 = (java.util.LinkedHashMap) r9
            if (r10 != r11) goto Le
            od.q r9 = od.q.f9570u
            return r9
        Le:
            r0 = 0
            r1 = 1
            if (r11 <= r10) goto L14
            r2 = r1
            goto L15
        L14:
            r2 = r0
        L15:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L1a:
            if (r2 == 0) goto L1f
            if (r10 >= r11) goto L93
            goto L21
        L1f:
            if (r10 <= r11) goto L93
        L21:
            r4 = 0
            if (r2 == 0) goto L3c
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            java.lang.Object r5 = r9.get(r5)
            java.util.TreeMap r5 = (java.util.TreeMap) r5
            if (r5 != 0) goto L32
        L30:
            r7 = r4
            goto L52
        L32:
            java.util.NavigableSet r6 = r5.descendingKeySet()
            nd.f r7 = new nd.f
            r7.<init>(r5, r6)
            goto L52
        L3c:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            java.lang.Object r5 = r9.get(r5)
            java.util.TreeMap r5 = (java.util.TreeMap) r5
            if (r5 != 0) goto L49
            goto L30
        L49:
            java.util.Set r6 = r5.keySet()
            nd.f r7 = new nd.f
            r7.<init>(r5, r6)
        L52:
            if (r7 != 0) goto L55
            goto L92
        L55:
            java.lang.Object r5 = r7.f8983u
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r7.f8984v
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L61:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L8f
            java.lang.Object r7 = r6.next()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r2 == 0) goto L7a
            int r8 = r10 + 1
            if (r8 > r7) goto L61
            if (r7 > r11) goto L61
            goto L7e
        L7a:
            if (r11 > r7) goto L61
            if (r7 >= r10) goto L61
        L7e:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            java.lang.Object r10 = r5.get(r10)
            be.h.b(r10)
            r3.add(r10)
            r5 = r1
            r10 = r7
            goto L90
        L8f:
            r5 = r0
        L90:
            if (r5 != 0) goto L1a
        L92:
            return r4
        L93:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.h(n.a1, int, int):java.util.List");
    }

    public static ColorStateList i(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListC;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListC = f0.c.c(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListC;
    }

    public static ColorStateList j(Context context, kc.b bVar, int i) {
        int resourceId;
        ColorStateList colorStateListC;
        TypedArray typedArray = (TypedArray) bVar.f7621w;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListC = f0.c.c(context, resourceId)) == null) ? bVar.q(i) : colorStateListC;
    }

    public static ColorStateList k(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !e0.u(drawable)) {
            return null;
        }
        return e0.d(drawable).getColorStateList();
    }

    public static final String l(int i, int i10, String str) {
        h.e(str, "fileTempDir");
        return str + "/" + i + "." + i10 + ".data";
    }

    public static Drawable m(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableP;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableP = d.p(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableP;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class n(ge.b bVar) {
        h.e(bVar, "<this>");
        Class clsA = ((be.d) bVar).a();
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

    public static final String o(String str, int i) {
        h.e(str, "fileTempDir");
        return str + "/" + i + ".meta.data";
    }

    public static final zc.c p(e eVar, String str) {
        h.e(eVar, "download");
        return r(eVar, -1L, -1L, str, 0, 16);
    }

    public static zc.c r(e eVar, long j5, long j8, String str, int i, int i10) {
        if ((i10 & 8) != 0) {
            str = "GET";
        }
        String str2 = str;
        h.e(eVar, "download");
        if (j5 == -1) {
            j5 = 0;
        }
        String strValueOf = j8 == -1 ? "" : String.valueOf(j8);
        LinkedHashMap linkedHashMapK = t.K(eVar.A);
        linkedHashMapK.put("Range", "bytes=" + j5 + "-" + strValueOf);
        String str3 = eVar.f14952w;
        String str4 = eVar.f14953x;
        return new zc.c(str3, linkedHashMapK, str4, android.support.v4.media.session.b.w(str4), str2, eVar.L);
    }

    public static long s(double d10) {
        q1.c.g("not a normal value", x(d10));
        int exponent = Math.getExponent(d10);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d10) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | 4503599627370496L;
    }

    public static a5.d v(u5.d dVar, SQLiteDatabase sQLiteDatabase) {
        h.e(dVar, "refHolder");
        a5.d dVar2 = (a5.d) dVar.f12784v;
        if (dVar2 != null && dVar2.f545u.equals(sQLiteDatabase)) {
            return dVar2;
        }
        a5.d dVar3 = new a5.d(sQLiteDatabase);
        dVar.f12784v = dVar3;
        return dVar3;
    }

    public static rd.c w(rd.c cVar) {
        h.e(cVar, "<this>");
        td.c cVar2 = cVar instanceof td.c ? (td.c) cVar : null;
        if (cVar2 == null || (cVar = cVar2.f12490w) != null) {
            return cVar;
        }
        rd.e eVar = (rd.e) cVar2.f().v(rd.d.f11571u);
        rd.c fVar = eVar != null ? new f((r) eVar, cVar2) : cVar2;
        cVar2.f12490w = fVar;
        return fVar;
    }

    public static boolean x(double d10) {
        return Math.getExponent(d10) <= 1023;
    }

    public static boolean y(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static final boolean z(r4.a aVar, int i, int i10) {
        h.e(aVar, "<this>");
        if (i > i10 && aVar.f11413l) {
            return false;
        }
        Set set = aVar.f11414m;
        return aVar.f11412k && (set == null || !set.contains(Integer.valueOf(i)));
    }

    public abstract void G(int i);

    public abstract void H(View view, int i, int i10);

    public abstract void I(View view, float f, float f4);

    public abstract boolean P(View view, int i);

    public abstract int a(View view, int i);

    public abstract int b(View view, int i);

    public int t(View view) {
        return 0;
    }

    public int u() {
        return 0;
    }

    public void E() {
    }

    public void D(int i, int i10) {
    }

    public void F(View view, int i) {
    }
}
