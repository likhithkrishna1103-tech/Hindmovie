package cf;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import c.e0;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import hf.v;
import hf.y;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import k8.b0;
import k8.c0;
import k8.z;
import ke.a0;
import l6.d0;
import l6.o;
import l6.s;
import p1.n0;
import v1.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static final hf.c A(InputStream inputStream) {
        Logger logger = hf.m.f6128a;
        be.h.e(inputStream, "<this>");
        return new hf.c(inputStream, new y());
    }

    public static final hf.c B(Socket socket) throws IOException {
        Logger logger = hf.m.f6128a;
        v vVar = new v(socket);
        InputStream inputStream = socket.getInputStream();
        be.h.d(inputStream, "getInputStream(...)");
        return new hf.c(vVar, new hf.c(inputStream, vVar));
    }

    public static int C(int i) {
        int[] iArr = {1, 2, 3};
        for (int i10 = 0; i10 < 3; i10++) {
            int i11 = iArr[i10];
            int i12 = i11 - 1;
            if (i11 == 0) {
                throw null;
            }
            if (i12 == i) {
                return i11;
            }
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0084 -> B:25:0x0067). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0087 -> B:25:0x0067). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(java.util.List r6, z0.t r7, td.c r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof z0.c
            if (r0 == 0) goto L13
            r0 = r8
            z0.c r0 = (z0.c) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            z0.c r0 = new z0.c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f14754z
            int r1 = r0.A
            r2 = 2
            r3 = 1
            sd.a r4 = sd.a.f11942u
            if (r1 == 0) goto L42
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            java.util.Iterator r6 = r0.f14753y
            java.io.Serializable r7 = r0.f14752x
            be.n r7 = (be.n) r7
            i5.a.Q(r8)     // Catch: java.lang.Throwable -> L30
            goto L67
        L30:
            r8 = move-exception
            goto L80
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            java.io.Serializable r6 = r0.f14752x
            java.util.List r6 = (java.util.List) r6
            i5.a.Q(r8)
            goto L5c
        L42:
            i5.a.Q(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            z0.e r1 = new z0.e
            r5 = 0
            r1.<init>(r6, r8, r5)
            r0.f14752x = r8
            r0.A = r3
            java.lang.Object r6 = r7.a(r1, r0)
            if (r6 != r4) goto L5b
            goto L95
        L5b:
            r6 = r8
        L5c:
            be.n r7 = new be.n
            r7.<init>()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L67:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L8d
            java.lang.Object r8 = r6.next()
            ae.l r8 = (ae.l) r8
            r0.f14752x = r7     // Catch: java.lang.Throwable -> L30
            r0.f14753y = r6     // Catch: java.lang.Throwable -> L30
            r0.A = r2     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = r8.a(r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r4) goto L67
            goto L95
        L80:
            java.lang.Object r1 = r7.f2045u
            if (r1 != 0) goto L87
            r7.f2045u = r8
            goto L67
        L87:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            com.bumptech.glide.d.d(r1, r8)
            goto L67
        L8d:
            java.lang.Object r6 = r7.f2045u
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            if (r6 != 0) goto L96
            nd.k r4 = nd.k.f8990a
        L95:
            return r4
        L96:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cf.l.a(java.util.List, z0.t, td.c):java.lang.Object");
    }

    public static void b(StringBuilder sb2, Object obj, ae.l lVar) {
        if (lVar != null) {
            sb2.append((CharSequence) lVar.a(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb2.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb2.append(((Character) obj).charValue());
        } else {
            sb2.append((CharSequence) obj.toString());
        }
    }

    public static u.j c(a0 a0Var) {
        u.h hVar = new u.h();
        hVar.f12520c = new u.k();
        u.j jVar = new u.j(hVar);
        hVar.f12519b = jVar;
        hVar.f12518a = l4.a.class;
        try {
            a0Var.D(true, new ke.i(2, new l4.b(hVar, 0, a0Var)));
            hVar.f12518a = "Deferred.asListenableFuture";
            return jVar;
        } catch (Exception e10) {
            jVar.f12523v.k(e10);
            return jVar;
        }
    }

    public static void g(String str, boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void h(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static com.bumptech.glide.i k(com.bumptech.glide.b bVar, List list, com.bumptech.glide.c cVar) {
        c6.k fVar;
        c6.k aVar;
        int i;
        f6.a aVar2;
        ContentResolver contentResolver;
        Class cls;
        f6.a aVar3 = bVar.f2760u;
        f6.f fVar2 = bVar.f2763x;
        com.bumptech.glide.e eVar = bVar.f2762w;
        Context applicationContext = eVar.getApplicationContext();
        wb.c cVar2 = eVar.f2778h;
        com.bumptech.glide.i iVar = new com.bumptech.glide.i();
        l6.l lVar = new l6.l();
        q6.c cVar3 = iVar.f2790g;
        synchronized (cVar3) {
            cVar3.f11021u.add(lVar);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 27) {
            iVar.i(new s());
        }
        Resources resources = applicationContext.getResources();
        ArrayList arrayListF = iVar.f();
        p6.a aVar4 = new p6.a(applicationContext, arrayListF, aVar3, fVar2);
        c6.k d0Var = new d0(aVar3, new z(17));
        o oVar = new o(iVar.f(), resources.getDisplayMetrics(), aVar3, fVar2);
        if (i10 < 28 || !((Map) cVar2.f14088v).containsKey(com.bumptech.glide.c.class)) {
            fVar = new l6.f(oVar, 0);
            aVar = new l6.a(oVar, 2, fVar2);
        } else {
            aVar = new l6.g(1);
            fVar = new l6.g(0);
        }
        if (i10 >= 28) {
            i = i10;
            aVar2 = aVar3;
            iVar.d("Animation", InputStream.class, Drawable.class, new n6.a(new h4.z(arrayListF, 28, fVar2), 1));
            iVar.d("Animation", ByteBuffer.class, Drawable.class, new n6.a(new h4.z(arrayListF, 28, fVar2), 0));
        } else {
            i = i10;
            aVar2 = aVar3;
        }
        c6.k cVar4 = new n6.c(applicationContext);
        c6.l bVar2 = new l6.b(fVar2);
        q6.a iVar2 = new e6.i(3, false);
        q6.a dVar = new q6.d(1);
        ContentResolver contentResolver2 = applicationContext.getContentResolver();
        iVar.a(ByteBuffer.class, new i6.c(2));
        iVar.a(InputStream.class, new u5.c(20, fVar2));
        iVar.d("Bitmap", ByteBuffer.class, Bitmap.class, fVar);
        iVar.d("Bitmap", InputStream.class, Bitmap.class, aVar);
        String str = Build.FINGERPRINT;
        if ("robolectric".equals(str)) {
            contentResolver = contentResolver2;
            cls = ParcelFileDescriptor.class;
        } else {
            contentResolver = contentResolver2;
            c6.k fVar3 = new l6.f(oVar, 1);
            cls = ParcelFileDescriptor.class;
            iVar.d("Bitmap", cls, Bitmap.class, fVar3);
        }
        f6.a aVar5 = aVar2;
        iVar.d("Bitmap", AssetFileDescriptor.class, Bitmap.class, new d0(aVar5, new k8.a0(16)));
        iVar.d("Bitmap", cls, Bitmap.class, d0Var);
        i6.s sVar = i6.a0.f6377b;
        iVar.c(Bitmap.class, Bitmap.class, sVar);
        iVar.d("Bitmap", Bitmap.class, Bitmap.class, new l6.z(0));
        iVar.b(Bitmap.class, bVar2);
        iVar.d("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new l6.a(resources, fVar));
        iVar.d("BitmapDrawable", InputStream.class, BitmapDrawable.class, new l6.a(resources, aVar));
        iVar.d("BitmapDrawable", cls, BitmapDrawable.class, new l6.a(resources, d0Var));
        iVar.b(BitmapDrawable.class, new h4.z(aVar5, 26, bVar2));
        iVar.d("Animation", InputStream.class, p6.b.class, new p6.i(arrayListF, aVar4, fVar2));
        iVar.d("Animation", ByteBuffer.class, p6.b.class, aVar4);
        iVar.b(p6.b.class, new c0(21));
        iVar.c(a6.d.class, a6.d.class, sVar);
        iVar.d("Bitmap", a6.d.class, Bitmap.class, new l6.c(aVar5));
        iVar.d("legacy_append", Uri.class, Drawable.class, cVar4);
        iVar.d("legacy_append", Uri.class, Bitmap.class, new l6.a(cVar4, 1, aVar5));
        iVar.j(new com.bumptech.glide.load.data.h(2));
        iVar.c(File.class, ByteBuffer.class, new i6.a0(3));
        iVar.c(File.class, InputStream.class, new i6.g(new i6.c(5)));
        iVar.d("legacy_append", File.class, File.class, new l6.z(2));
        iVar.c(File.class, cls, new i6.g(new i6.c(4)));
        iVar.c(File.class, File.class, sVar);
        iVar.j(new com.bumptech.glide.load.data.m(fVar2));
        if (!"robolectric".equals(str)) {
            iVar.j(new com.bumptech.glide.load.data.h(1));
        }
        i6.s eVar2 = new i6.e(applicationContext, 2);
        i6.s eVar3 = new i6.e(applicationContext, 0);
        i6.s eVar4 = new i6.e(applicationContext, 1);
        Class cls2 = Integer.TYPE;
        iVar.c(cls2, InputStream.class, eVar2);
        iVar.c(Integer.class, InputStream.class, eVar2);
        iVar.c(cls2, AssetFileDescriptor.class, eVar3);
        iVar.c(Integer.class, AssetFileDescriptor.class, eVar3);
        iVar.c(cls2, Drawable.class, eVar4);
        iVar.c(Integer.class, Drawable.class, eVar4);
        iVar.c(Uri.class, InputStream.class, new i6.e(applicationContext, 5));
        iVar.c(Uri.class, AssetFileDescriptor.class, new i6.e(applicationContext, 4));
        i6.s yVar = new i6.y(resources, 2);
        i6.s yVar2 = new i6.y(resources, 0);
        i6.s yVar3 = new i6.y(resources, 1);
        iVar.c(Integer.class, Uri.class, yVar);
        iVar.c(cls2, Uri.class, yVar);
        iVar.c(Integer.class, AssetFileDescriptor.class, yVar2);
        iVar.c(cls2, AssetFileDescriptor.class, yVar2);
        iVar.c(Integer.class, InputStream.class, yVar3);
        iVar.c(cls2, InputStream.class, yVar3);
        iVar.c(String.class, InputStream.class, new b6.b(1));
        iVar.c(Uri.class, InputStream.class, new b6.b(1));
        iVar.c(String.class, InputStream.class, new i6.a0(6));
        iVar.c(String.class, cls, new i6.a0(5));
        iVar.c(String.class, AssetFileDescriptor.class, new i6.a0(4));
        iVar.c(Uri.class, InputStream.class, new i6.a(applicationContext.getAssets(), 1));
        iVar.c(Uri.class, AssetFileDescriptor.class, new i6.a(applicationContext.getAssets(), 0));
        iVar.c(Uri.class, InputStream.class, new i6.e(applicationContext, 6));
        iVar.c(Uri.class, InputStream.class, new i6.e(applicationContext, 7));
        if (i >= 29) {
            iVar.c(Uri.class, InputStream.class, new j6.b(applicationContext, InputStream.class));
            iVar.c(Uri.class, cls, new j6.b(applicationContext, cls));
        }
        ContentResolver contentResolver3 = contentResolver;
        iVar.c(Uri.class, InputStream.class, new i6.c0(contentResolver3, 2));
        iVar.c(Uri.class, cls, new i6.c0(contentResolver3, 1));
        iVar.c(Uri.class, AssetFileDescriptor.class, new i6.c0(contentResolver3, 0));
        iVar.c(Uri.class, InputStream.class, new i6.a0(7));
        iVar.c(URL.class, InputStream.class, new j6.e());
        iVar.c(Uri.class, File.class, new i6.e(applicationContext, 3));
        iVar.c(i6.h.class, InputStream.class, new b6.b(2));
        iVar.c(byte[].class, ByteBuffer.class, new i6.a0(1));
        iVar.c(byte[].class, InputStream.class, new i6.a0(2));
        iVar.c(Uri.class, Uri.class, sVar);
        iVar.c(Drawable.class, Drawable.class, sVar);
        iVar.d("legacy_append", Drawable.class, Drawable.class, new l6.z(1));
        iVar.k(Bitmap.class, BitmapDrawable.class, new i4.e(resources, 1));
        iVar.k(Bitmap.class, byte[].class, iVar2);
        iVar.k(Drawable.class, byte[].class, new kc.b(aVar5, iVar2, dVar, 12));
        iVar.k(p6.b.class, byte[].class, dVar);
        c6.k d0Var2 = new d0(aVar5, new b0(16));
        iVar.d("legacy_append", ByteBuffer.class, Bitmap.class, d0Var2);
        iVar.d("legacy_append", ByteBuffer.class, BitmapDrawable.class, new l6.a(resources, d0Var2));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            OkHttpGlideModule okHttpGlideModule = (OkHttpGlideModule) it.next();
            try {
                okHttpGlideModule.getClass();
                iVar.l(new b6.b(0));
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ".concat(okHttpGlideModule.getClass().getName()), e10);
            }
        }
        if (cVar != null) {
            cVar.s(applicationContext, bVar, iVar);
        }
        return iVar;
    }

    public static void l(String str, String str2, Object obj) {
        String strT = t(str);
        if (Log.isLoggable(strT, 3)) {
            Log.d(strT, String.format(str2, obj));
        }
    }

    public static Bitmap m(byte[] bArr, int i, int i10) throws IOException {
        BitmapFactory.Options options;
        int i11 = 0;
        int iE = 1;
        if (i10 != -1) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, i, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            for (int iMax = Math.max(options.outWidth, options.outHeight); iMax > i10; iMax /= 2) {
                options.inSampleSize *= 2;
            }
        } else {
            options = null;
        }
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i, options);
        if (options != null) {
            options.inSampleSize = 1;
        }
        if (bitmapDecodeByteArray == null) {
            throw n0.a(new IllegalStateException(), "Could not decode image data");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            h1.g gVar = new h1.g(byteArrayInputStream);
            byteArrayInputStream.close();
            h1.c cVarC = gVar.c("Orientation");
            if (cVarC != null) {
                try {
                    iE = cVarC.e(gVar.f);
                } catch (NumberFormatException unused) {
                }
            }
            switch (iE) {
                case 3:
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    i11 = 180;
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                case 8:
                    i11 = 270;
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    i11 = 90;
                    break;
            }
            if (i11 == 0) {
                return bitmapDecodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(i11);
            return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
        } finally {
        }
    }

    public static final boolean n(String str, String str2) {
        be.h.e(str, "current");
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i = 0;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i < str.length()) {
                    char cCharAt = str.charAt(i);
                    int i12 = i11 + 1;
                    if (i11 == 0 && cCharAt != '(') {
                        break;
                    }
                    if (cCharAt == '(') {
                        i10++;
                    } else if (cCharAt == ')' && i10 - 1 == 0 && i11 != str.length() - 1) {
                        break;
                    }
                    i++;
                    i11 = i12;
                } else if (i10 == 0) {
                    String strSubstring = str.substring(1, str.length() - 1);
                    be.h.d(strSubstring, "substring(...)");
                    return be.h.a(ie.e.b0(strSubstring).toString(), str2);
                }
            }
        }
        return false;
    }

    public static void o(String str, String str2, Exception exc) {
        String strT = t(str);
        if (Log.isLoggable(strT, 6)) {
            Log.e(strT, str2, exc);
        }
    }

    public static final Object p(r4.l lVar, String str, td.c cVar) {
        Object objA = lVar.a(str, new e0(2), cVar);
        return objA == sd.a.f11942u ? objA : nd.k.f8990a;
    }

    public static byte[] q(v1.h hVar, String str, byte[] bArr, Map map) throws f2.a0 {
        Map map2;
        List list;
        v1.c0 c0Var = new v1.c0(hVar);
        Map map3 = Collections.EMPTY_MAP;
        Uri uri = Uri.parse(str);
        s1.d.i(uri, "The uri must be set.");
        v1.m mVar = new v1.m(uri, 0L, 2, bArr, map, 0L, -1L, null, 1);
        int i = 0;
        int i10 = 0;
        v1.m mVarA = mVar;
        while (true) {
            try {
                v1.k kVar = new v1.k(c0Var, mVarA);
                try {
                    try {
                        byte[] bArrB = ba.b.b(kVar);
                        s1.b0.g(kVar);
                        return bArrB;
                    } catch (x e10) {
                        int i11 = e10.f13177x;
                        String str2 = null;
                        if ((i11 == 307 || i11 == 308) && i10 < 5 && (map2 = e10.f13178y) != null && (list = (List) map2.get("Location")) != null && !list.isEmpty()) {
                            str2 = (String) list.get(i);
                        }
                        if (str2 == null) {
                            throw e10;
                        }
                        i10++;
                        v1.l lVarA = mVarA.a();
                        lVarA.f13150a = Uri.parse(str2);
                        mVarA = lVarA.a();
                        s1.b0.g(kVar);
                    }
                } catch (Throwable th) {
                    s1.b0.g(kVar);
                    throw th;
                }
            } catch (Exception e11) {
                throw new f2.a0(mVar, c0Var.f13128w, c0Var.f13126u.k(), c0Var.f13127v, e11);
            }
        }
    }

    public static final String r(Collection collection) {
        be.h.e(collection, "collection");
        if (collection.isEmpty()) {
            return " }";
        }
        return ie.g.D(od.i.b0(collection, ",\n", "\n", "\n", null, 56)) + "},";
    }

    public static Set s() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static String t(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return "TRuntime.".concat(str);
        }
        String strConcat = "TRuntime.".concat(str);
        return strConcat.length() > 23 ? strConcat.substring(0, 23) : strConcat;
    }

    public static final boolean u(AssertionError assertionError) {
        Logger logger = hf.m.f6128a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? ie.e.N(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    public static boolean v(Throwable th) {
        return Build.VERSION.SDK_INT == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/NotProvisionedException;.<init>(");
    }

    public static boolean w(Throwable th) {
        return Build.VERSION.SDK_INT == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/ResourceBusyException;.<init>(");
    }

    public static final hf.b z(Socket socket) throws IOException {
        Logger logger = hf.m.f6128a;
        v vVar = new v(socket);
        OutputStream outputStream = socket.getOutputStream();
        be.h.d(outputStream, "getOutputStream(...)");
        return new hf.b(vVar, new hf.b(outputStream, vVar));
    }

    public abstract boolean d(u.g gVar, u.c cVar, u.c cVar2);

    public abstract boolean e(u.g gVar, Object obj, Object obj2);

    public abstract boolean f(u.g gVar, u.f fVar, u.f fVar2);

    public abstract void x(u.f fVar, u.f fVar2);

    public abstract void y(u.f fVar, Thread thread);
}
