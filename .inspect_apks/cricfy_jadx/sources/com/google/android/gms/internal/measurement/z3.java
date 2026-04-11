package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.view.View;
import app.cricfy.tv.app.ProApplication;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z3 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static o.t3 f2741v;

    public static float c(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float d(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static final String g(Object[] objArr, int i, int i10, sd.e eVar) {
        StringBuilder sb = new StringBuilder((i10 * 3) + 2);
        sb.append("[");
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i11];
            if (obj == eVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        ge.i.d(string, "toString(...)");
        return string;
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static byte[] i(ArrayDeque arrayDeque, int i) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == i) {
            return bArr;
        }
        int length = i - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static com.bumptech.glide.k j(com.bumptech.glide.b bVar, List list, w4.v vVar) {
        x6.j aVar;
        x6.j gVar;
        int i;
        a7.b bVar2;
        ContentResolver contentResolver;
        Class cls;
        a7.b bVar3 = bVar.f2193v;
        a7.g gVar2 = bVar.f2196y;
        com.bumptech.glide.g gVar3 = bVar.f2195x;
        Context applicationContext = gVar3.getApplicationContext();
        pc.c cVar = gVar3.f2207h;
        com.bumptech.glide.k kVar = new com.bumptech.glide.k();
        g7.m mVar = new g7.m();
        i6.c cVar2 = kVar.f2219g;
        synchronized (cVar2) {
            cVar2.f6231a.add(mVar);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 27) {
            kVar.k(new g7.t());
        }
        Resources resources = applicationContext.getResources();
        ArrayList arrayListF = kVar.f();
        k7.a aVar2 = new k7.a(applicationContext, arrayListF, bVar3, gVar2);
        x6.j g0Var = new g7.g0(bVar3, new f9.z(13));
        g7.p pVar = new g7.p(kVar.f(), resources.getDisplayMetrics(), bVar3, gVar2);
        if (i10 < 28 || !((Map) cVar.f10180v).containsKey(com.bumptech.glide.c.class)) {
            x6.j fVar = new g7.f(pVar, 0);
            aVar = new g7.a(2, pVar, gVar2);
            gVar = fVar;
        } else {
            x6.j gVar4 = new g7.g(1);
            gVar = new g7.g(0);
            aVar = gVar4;
        }
        if (i10 >= 28) {
            i = i10;
            bVar2 = bVar3;
            kVar.d("Animation", InputStream.class, Drawable.class, new i7.a(new i2.k(arrayListF, gVar2), 1));
            kVar.d("Animation", ByteBuffer.class, Drawable.class, new i7.a(new i2.k(arrayListF, gVar2), 0));
        } else {
            i = i10;
            bVar2 = bVar3;
        }
        x6.j cVar3 = new i7.c(applicationContext);
        x6.k bVar4 = new g7.b(gVar2);
        l7.b oVar = new ag.o(2, (byte) 0);
        l7.b dVar = new l7.d(1);
        ContentResolver contentResolver2 = applicationContext.getContentResolver();
        kVar.b(ByteBuffer.class, new d7.c(2));
        kVar.b(InputStream.class, new p6.d(8, gVar2));
        kVar.d("Bitmap", ByteBuffer.class, Bitmap.class, gVar);
        kVar.d("Bitmap", InputStream.class, Bitmap.class, aVar);
        String str = Build.FINGERPRINT;
        if ("robolectric".equals(str)) {
            contentResolver = contentResolver2;
            cls = ParcelFileDescriptor.class;
        } else {
            contentResolver = contentResolver2;
            x6.j fVar2 = new g7.f(pVar, 1);
            cls = ParcelFileDescriptor.class;
            kVar.d("Bitmap", cls, Bitmap.class, fVar2);
        }
        a7.b bVar5 = bVar2;
        kVar.d("Bitmap", AssetFileDescriptor.class, Bitmap.class, new g7.g0(bVar5, new f9.a0(12)));
        kVar.d("Bitmap", cls, Bitmap.class, g0Var);
        d7.u uVar = d7.d0.f3463b;
        kVar.a(Bitmap.class, Bitmap.class, uVar);
        kVar.d("Bitmap", Bitmap.class, Bitmap.class, new g7.b0(0));
        kVar.c(Bitmap.class, bVar4);
        kVar.d("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new g7.a(resources, gVar));
        kVar.d("BitmapDrawable", InputStream.class, BitmapDrawable.class, new g7.a(resources, aVar));
        kVar.d("BitmapDrawable", cls, BitmapDrawable.class, new g7.a(resources, g0Var));
        kVar.c(BitmapDrawable.class, new l4.c0(24, bVar5, bVar4));
        kVar.d("Animation", InputStream.class, k7.b.class, new k7.i(arrayListF, aVar2, gVar2));
        kVar.d("Animation", ByteBuffer.class, k7.b.class, aVar2);
        kVar.c(k7.b.class, new f9.z(15));
        kVar.a(v6.d.class, v6.d.class, uVar);
        kVar.d("Bitmap", v6.d.class, Bitmap.class, new g7.c(bVar5));
        kVar.d("legacy_append", Uri.class, Drawable.class, cVar3);
        kVar.d("legacy_append", Uri.class, Bitmap.class, new g7.a(1, cVar3, bVar5));
        kVar.i(new com.bumptech.glide.load.data.g(2));
        kVar.a(File.class, ByteBuffer.class, new d7.d0(3));
        kVar.a(File.class, InputStream.class, new d7.i(new d7.c(5)));
        kVar.d("legacy_append", File.class, File.class, new g7.b0(2));
        kVar.a(File.class, cls, new d7.i(new d7.c(4)));
        kVar.a(File.class, File.class, uVar);
        kVar.i(new com.bumptech.glide.load.data.l(gVar2));
        if (!"robolectric".equals(str)) {
            kVar.i(new com.bumptech.glide.load.data.g(1));
        }
        d7.u gVar5 = new d7.g(applicationContext, 2);
        d7.u gVar6 = new d7.g(applicationContext, 0);
        d7.u gVar7 = new d7.g(applicationContext, 1);
        Class cls2 = Integer.TYPE;
        kVar.a(cls2, InputStream.class, gVar5);
        kVar.a(Integer.class, InputStream.class, gVar5);
        kVar.a(cls2, AssetFileDescriptor.class, gVar6);
        kVar.a(Integer.class, AssetFileDescriptor.class, gVar6);
        kVar.a(cls2, Drawable.class, gVar7);
        kVar.a(Integer.class, Drawable.class, gVar7);
        kVar.a(Uri.class, InputStream.class, new d7.g(applicationContext, 5));
        kVar.a(Uri.class, AssetFileDescriptor.class, new d7.g(applicationContext, 4));
        d7.u b0Var = new d7.b0(resources, 2);
        d7.u b0Var2 = new d7.b0(resources, 0);
        d7.u b0Var3 = new d7.b0(resources, 1);
        kVar.a(Integer.class, Uri.class, b0Var);
        kVar.a(cls2, Uri.class, b0Var);
        kVar.a(Integer.class, AssetFileDescriptor.class, b0Var2);
        kVar.a(cls2, AssetFileDescriptor.class, b0Var2);
        kVar.a(Integer.class, InputStream.class, b0Var3);
        kVar.a(cls2, InputStream.class, b0Var3);
        kVar.a(String.class, InputStream.class, new w6.b(1));
        kVar.a(Uri.class, InputStream.class, new w6.b(1));
        kVar.a(String.class, InputStream.class, new d7.d0(6));
        kVar.a(String.class, cls, new d7.d0(5));
        kVar.a(String.class, AssetFileDescriptor.class, new d7.d0(4));
        kVar.a(Uri.class, InputStream.class, new d7.a(applicationContext.getAssets(), 1));
        kVar.a(Uri.class, AssetFileDescriptor.class, new d7.a(applicationContext.getAssets(), 0));
        kVar.a(Uri.class, InputStream.class, new d7.g(applicationContext, 6));
        kVar.a(Uri.class, InputStream.class, new d7.g(applicationContext, 7));
        if (i >= 29) {
            kVar.a(Uri.class, InputStream.class, new e7.b(applicationContext, InputStream.class));
            kVar.a(Uri.class, cls, new e7.b(applicationContext, cls));
        }
        boolean zContainsKey = ((Map) cVar.f10180v).containsKey(com.bumptech.glide.f.class);
        ContentResolver contentResolver3 = contentResolver;
        kVar.a(Uri.class, InputStream.class, new d7.f0(contentResolver3, zContainsKey, 2));
        kVar.a(Uri.class, cls, new d7.f0(contentResolver3, zContainsKey, 1));
        kVar.a(Uri.class, AssetFileDescriptor.class, new d7.f0(contentResolver3, zContainsKey, 0));
        kVar.a(Uri.class, InputStream.class, new d7.d0(7));
        kVar.a(URL.class, InputStream.class, new e7.e());
        kVar.a(Uri.class, File.class, new d7.g(applicationContext, 3));
        kVar.a(d7.j.class, InputStream.class, new w6.b(2));
        kVar.a(byte[].class, ByteBuffer.class, new d7.d0(1));
        kVar.a(byte[].class, InputStream.class, new d7.d0(2));
        kVar.a(Uri.class, Uri.class, uVar);
        kVar.a(Drawable.class, Drawable.class, uVar);
        kVar.d("legacy_append", Drawable.class, Drawable.class, new g7.b0(1));
        kVar.j(Bitmap.class, BitmapDrawable.class, new l4.a(resources));
        kVar.j(Bitmap.class, byte[].class, oVar);
        kVar.j(Drawable.class, byte[].class, new l7.a(bVar5, oVar, dVar, 0));
        kVar.j(k7.b.class, byte[].class, dVar);
        x6.j g0Var2 = new g7.g0(bVar5, new f9.b0(12));
        kVar.d("legacy_append", ByteBuffer.class, Bitmap.class, g0Var2);
        kVar.d("legacy_append", ByteBuffer.class, BitmapDrawable.class, new g7.a(resources, g0Var2));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            OkHttpGlideModule okHttpGlideModule = (OkHttpGlideModule) it.next();
            try {
                okHttpGlideModule.getClass();
                kVar.l(new w6.b(0));
            } catch (AbstractMethodError e9) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ".concat(okHttpGlideModule.getClass().getName()), e9);
            }
        }
        if (vVar != null) {
            vVar.p(applicationContext, bVar, kVar);
        }
        return kVar;
    }

    public static int k(float f, int i, int i10) {
        if (i == i10 || f <= 0.0f) {
            return i;
        }
        if (f >= 1.0f) {
            return i10;
        }
        float f10 = ((i >> 24) & 255) / 255.0f;
        float f11 = ((i10 >> 24) & 255) / 255.0f;
        float fC = c(((i >> 16) & 255) / 255.0f);
        float fC2 = c(((i >> 8) & 255) / 255.0f);
        float fC3 = c((i & 255) / 255.0f);
        float fC4 = c(((i10 >> 16) & 255) / 255.0f);
        float fC5 = c(((i10 >> 8) & 255) / 255.0f);
        float fC6 = c((i10 & 255) / 255.0f);
        float fH = q4.a.h(f11, f10, f, f10);
        float fH2 = q4.a.h(fC4, fC, f, fC);
        float fH3 = q4.a.h(fC5, fC2, f, fC2);
        float fH4 = q4.a.h(fC6, fC3, f, fC3);
        float fD = d(fH2) * 255.0f;
        float fD2 = d(fH3) * 255.0f;
        return Math.round(d(fH4) * 255.0f) | (Math.round(fD) << 16) | (Math.round(fH * 255.0f) << 24) | (Math.round(fD2) << 8);
    }

    public static final Object l(h1.b bVar, h1.e eVar, Serializable serializable) {
        ge.i.e(bVar, "<this>");
        ge.i.e(eVar, "key");
        Object objCopyOf = bVar.f5473a.get(eVar);
        if (objCopyOf instanceof byte[]) {
            byte[] bArr = (byte[]) objCopyOf;
            objCopyOf = Arrays.copyOf(bArr, bArr.length);
            ge.i.d(objCopyOf, "copyOf(this, size)");
        }
        return objCopyOf == null ? serializable : objCopyOf;
    }

    public static Object m(String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 34) {
            return p0.a.a(str, bundle);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (e.a.class.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static long n(double d10) {
        com.bumptech.glide.d.f("not a normal value", o(d10));
        int exponent = Math.getExponent(d10);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d10) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | 4503599627370496L;
    }

    public static boolean o(double d10) {
        return Math.getExponent(d10) <= 1023;
    }

    public static e6.b r(String str) {
        try {
            return s(new JSONArray(str));
        } catch (JSONException unused) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("All");
            String[] strArrSplit = str.split("\n");
            int length = strArrSplit.length;
            int i = 0;
            int i10 = 0;
            y5.h hVar = null;
            while (true) {
                int i11 = 1;
                if (i10 >= length) {
                    break;
                }
                String str2 = strArrSplit[i10];
                if (hVar == null) {
                    hVar = new y5.h();
                    arrayList.add(hVar);
                }
                if (str2.contains("group-title=")) {
                    Matcher matcher = Pattern.compile("group-title=\"([^\"]+)\"").matcher(str2);
                    if (matcher.find()) {
                        String strReplaceAll = matcher.group(1).replaceAll("^\\s+|$", "");
                        hVar.f14943a = strReplaceAll;
                        if (!arrayList2.contains(strReplaceAll)) {
                            arrayList2.add(strReplaceAll);
                        }
                    }
                }
                if (str2.startsWith("#EXTINF")) {
                    String[] strArrSplit2 = str2.split(",");
                    hVar.f14944b = strArrSplit2[strArrSplit2.length - 1].replaceAll("^\\s+|$", "");
                    if (str2.contains("tvg-logo=")) {
                        Matcher matcher2 = Pattern.compile("tvg-logo=\"([^\"]+)\"").matcher(str2);
                        if (matcher2.find()) {
                            hVar.f14945c = matcher2.group(1).replaceAll("^\\s+|$", "");
                        }
                    }
                } else if (str2.startsWith("#KODIPROP:inputstream.adaptive.license_type=")) {
                    String lowerCase = str2.toLowerCase();
                    if (lowerCase.contains("clearkey")) {
                        i11 = i;
                    } else if (!lowerCase.contains("widevine")) {
                        i11 = 2;
                    }
                    hVar.f14950j = i11;
                } else if (str2.startsWith("#KODIPROP:inputstream.adaptive.license_key=")) {
                    String[] strArrSplit3 = str2.split("#KODIPROP:inputstream.adaptive.license_key=");
                    if (strArrSplit3.length > 0) {
                        String str3 = strArrSplit3[1];
                        try {
                            JSONObject jSONObject = new JSONObject(str3).getJSONArray("keys").getJSONObject(i);
                            hVar.i = j4.a(jSONObject.getString("kid")) + ":" + j4.a(jSONObject.getString("k"));
                        } catch (JSONException unused2) {
                            String strReplaceAll2 = str3.replaceAll("^\\s+|$", "");
                            if (strReplaceAll2.startsWith("http") || strReplaceAll2.contains(":")) {
                                hVar.i = strReplaceAll2;
                            }
                        }
                    }
                } else if (str2.startsWith("#EXTVLCOPT:http-user-agent=")) {
                    hVar.f14947e = str2.split("#EXTVLCOPT:http-user-agent=")[1];
                } else if (str2.startsWith("#EXTVLCOPT:http-referer=")) {
                    hVar.f14948g = str2.split("#EXTVLCOPT:http-referer=")[1];
                } else if (str2.startsWith("#EXTVLCOPT:http-referrer=")) {
                    hVar.f14948g = str2.split("#EXTVLCOPT:http-referrer=")[1];
                } else if (str2.startsWith("#EXTVLCOPT:http-origin=")) {
                    hVar.f14949h = str2.split("#EXTVLCOPT:http-origin=")[1];
                } else if (str2.startsWith("#EXTHTTP:")) {
                    String str4 = str2.split("#EXTHTTP:")[1];
                    try {
                        JSONObject jSONObject2 = new JSONObject(str4);
                        if (jSONObject2.has("cookie")) {
                            hVar.f = jSONObject2.getString("cookie");
                        } else if (jSONObject2.has("Cookie")) {
                            hVar.f = jSONObject2.getString("Cookie");
                        }
                    } catch (JSONException unused3) {
                        hVar.f = str4;
                    }
                } else if (str2.startsWith("http")) {
                    hVar.f14946d = str2.replaceAll("^[\\s\\r\\n]+|[\\s\\r\\n]+$", "");
                    hVar = null;
                }
                i10++;
                i = 0;
            }
            if (arrayList2.size() == 1) {
                arrayList2.clear();
            }
            return new e6.b(arrayList, arrayList2);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:72:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static e6.b s(org.json.JSONArray r10) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.z3.s(org.json.JSONArray):e6.b");
    }

    public static final void t(Object[] objArr, int i, int i10) {
        ge.i.e(objArr, "<this>");
        while (i < i10) {
            objArr[i] = null;
            i++;
        }
    }

    public static boolean u(Context context) {
        Activity activity = (Activity) context;
        String str = ((ProApplication) activity.getApplication()).G;
        if (str == null) {
            return false;
        }
        String str2 = a6.a.b("UWLbaW91OMkmgdTbkB8bL29hkBnhkWHbg3IlOBPwjJG0fBIhOMIhfW5skBPugJFrOF==") + str + " )";
        h.g gVar = new h.g(activity);
        gVar.setTitle(str2);
        gVar.c(a6.a.b("VImZIF=="), new a6.c(1, activity));
        gVar.f5346a.f5300m = false;
        h.h hVarCreate = gVar.create();
        hVarCreate.show();
        hVarCreate.getWindow().setBackgroundDrawable(new ColorDrawable(-7829368));
        return true;
    }

    public static void v(Context context) {
        h.g gVar = new h.g(context);
        gVar.setTitle(a6.a.b("WW91OBDmgok0OMIsSUF=") + context.getString(q5.o.app_name) + a6.a.b("OBnhOPZig3VnSJGASYSqL2Hm"));
        gVar.c(a6.a.b("VImZIF=="), new a6.c(0, context));
        gVar.f5346a.f5300m = false;
        h.h hVarCreate = gVar.create();
        hVarCreate.show();
        hVarCreate.getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
    }

    public static byte[] w(nc.d dVar) throws IOException {
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(0) * 2));
        int i = 0;
        while (i < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i10 = 0;
            while (i10 < iMin2) {
                int i11 = dVar.read(bArr, i10, iMin2 - i10);
                if (i11 == -1) {
                    return i(arrayDeque, i);
                }
                i10 += i11;
                i += i11;
            }
            long j4 = ((long) iMin) * ((long) (iMin < 4096 ? 4 : 2));
            iMin = j4 > 2147483647L ? Integer.MAX_VALUE : j4 < -2147483648L ? Integer.MIN_VALUE : (int) j4;
        }
        if (dVar.read() == -1) {
            return i(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static final void x(dd.e eVar, dd.e eVar2) {
        ge.i.e(eVar, "<this>");
        ge.i.e(eVar2, "downloadInfo");
        eVar2.f3676v = eVar.f3676v;
        eVar2.h(eVar.f3677w);
        eVar2.j(eVar.f3678x);
        eVar2.g(eVar.f3679y);
        eVar2.f3680z = eVar.f3680z;
        cd.h hVar = eVar.A;
        ge.i.e(hVar, "<set-?>");
        eVar2.A = hVar;
        eVar2.B = sd.s.C(eVar.B);
        eVar2.C = eVar.C;
        eVar2.D = eVar.D;
        cd.l lVar = eVar.E;
        ge.i.e(lVar, "<set-?>");
        eVar2.E = lVar;
        cd.g gVar = eVar.G;
        ge.i.e(gVar, "<set-?>");
        eVar2.G = gVar;
        eVar2.e(eVar.F);
        eVar2.H = eVar.H;
        eVar2.I = eVar.I;
        cd.a aVar = eVar.J;
        ge.i.e(aVar, "<set-?>");
        eVar2.J = aVar;
        eVar2.K = eVar.K;
        eVar2.L = eVar.L;
        md.g gVar2 = eVar.M;
        ge.i.e(gVar2, "<set-?>");
        eVar2.M = gVar2;
        eVar2.N = eVar.N;
        eVar2.O = eVar.O;
    }

    public static synchronized void y(o.t3 t3Var) {
        if (f2741v != null) {
            throw new IllegalStateException("init() already called");
        }
        f2741v = t3Var;
    }

    public abstract View p(int i);

    public abstract boolean q();
}
