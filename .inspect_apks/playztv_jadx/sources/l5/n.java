package l5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f7882a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet f7883b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f7884c = {80, 75, 3, 4};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f7885d = {31, -117, 8};

    public static c0 a(final String str, Callable callable, a2.a aVar) {
        j jVarA = str == null ? null : q5.g.f11013b.a(str);
        c0 c0Var = jVarA != null ? new c0(jVarA) : null;
        HashMap map = f7882a;
        if (str != null && map.containsKey(str)) {
            c0Var = (c0) map.get(str);
        }
        if (c0Var != null) {
            if (aVar != null) {
                aVar.run();
            }
            return c0Var;
        }
        c0 c0Var2 = new c0(callable, false);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final int i = 0;
            c0Var2.b(new y() { // from class: l5.l
                @Override // l5.y
                public final void onResult(Object obj) {
                    switch (i) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            HashMap map2 = n.f7882a;
                            map2.remove(str);
                            atomicBoolean.set(true);
                            if (map2.size() == 0) {
                                n.i();
                            }
                            break;
                        default:
                            HashMap map3 = n.f7882a;
                            map3.remove(str);
                            atomicBoolean.set(true);
                            if (map3.size() == 0) {
                                n.i();
                            }
                            break;
                    }
                }
            });
            final int i10 = 1;
            c0Var2.a(new y() { // from class: l5.l
                @Override // l5.y
                public final void onResult(Object obj) {
                    switch (i10) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            HashMap map2 = n.f7882a;
                            map2.remove(str);
                            atomicBoolean.set(true);
                            if (map2.size() == 0) {
                                n.i();
                            }
                            break;
                        default:
                            HashMap map3 = n.f7882a;
                            map3.remove(str);
                            atomicBoolean.set(true);
                            if (map3.size() == 0) {
                                n.i();
                            }
                            break;
                    }
                }
            });
            if (!atomicBoolean.get()) {
                map.put(str, c0Var2);
                if (map.size() == 1) {
                    i();
                }
            }
        }
        return c0Var2;
    }

    public static a0 b(Context context, String str, String str2) {
        j jVarA = str2 == null ? null : q5.g.f11013b.a(str2);
        if (jVarA != null) {
            return new a0(jVarA);
        }
        try {
            hf.q qVar = new hf.q(cf.l.A(context.getAssets().open(str)));
            return h(qVar, f7884c).booleanValue() ? f(context, new ZipInputStream(new hf.e(qVar, 1)), str2) : h(qVar, f7885d).booleanValue() ? c(new GZIPInputStream(new hf.e(qVar, 1)), str2) : c(new hf.e(qVar, 1), str2);
        } catch (IOException e10) {
            return new a0(e10);
        }
    }

    public static a0 c(InputStream inputStream, String str) {
        hf.q qVar = new hf.q(cf.l.A(inputStream));
        String[] strArr = w5.a.f13738y;
        return d(new w5.b(qVar), str, true);
    }

    public static a0 d(w5.b bVar, String str, boolean z2) {
        j jVarA;
        try {
            if (str == null) {
                jVarA = null;
            } else {
                try {
                    jVarA = q5.g.f11013b.a(str);
                } catch (Exception e10) {
                    a0 a0Var = new a0(e10);
                    if (z2) {
                        x5.g.b(bVar);
                    }
                    return a0Var;
                }
            }
            if (jVarA != null) {
                a0 a0Var2 = new a0(jVarA);
                if (z2) {
                    x5.g.b(bVar);
                }
                return a0Var2;
            }
            j jVarA2 = v5.r.a(bVar);
            if (str != null) {
                q5.g.f11013b.f11014a.k(str, jVarA2);
            }
            a0 a0Var3 = new a0(jVarA2);
            if (z2) {
                x5.g.b(bVar);
            }
            return a0Var3;
        } catch (Throwable th) {
            if (z2) {
                x5.g.b(bVar);
            }
            throw th;
        }
    }

    public static a0 e(int i, Context context, String str) {
        j jVarA = str == null ? null : q5.g.f11013b.a(str);
        if (jVarA != null) {
            return new a0(jVarA);
        }
        try {
            hf.q qVar = new hf.q(cf.l.A(context.getResources().openRawResource(i)));
            if (h(qVar, f7884c).booleanValue()) {
                return f(context, new ZipInputStream(new hf.e(qVar, 1)), str);
            }
            if (!h(qVar, f7885d).booleanValue()) {
                return c(new hf.e(qVar, 1), str);
            }
            try {
                return c(new GZIPInputStream(new hf.e(qVar, 1)), str);
            } catch (IOException e10) {
                return new a0(e10);
            }
        } catch (Resources.NotFoundException e11) {
            return new a0(e11);
        }
    }

    public static a0 f(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return g(context, zipInputStream, str);
        } finally {
            x5.g.b(zipInputStream);
        }
    }

    public static a0 g(Context context, ZipInputStream zipInputStream, String str) {
        j jVarA;
        x xVar;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (str == null) {
            jVarA = null;
        } else {
            try {
                jVarA = q5.g.f11013b.a(str);
            } catch (IOException e10) {
                return new a0(e10);
            }
        }
        if (jVarA != null) {
            return new a0(jVarA);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        j jVar = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                hf.q qVar = new hf.q(cf.l.A(zipInputStream));
                String[] strArr = w5.a.f13738y;
                jVar = d(new w5.b(qVar), null, false).f7823a;
            } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                String[] strArrSplit = name.split("/");
                map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
            } else if (name.contains(".ttf") || name.contains(".otf")) {
                String[] strArrSplit2 = name.split("/");
                String str2 = strArrSplit2[strArrSplit2.length - 1];
                String str3 = str2.split("\\.")[0];
                File file = new File(context.getCacheDir(), str2);
                new FileOutputStream(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i = zipInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    x5.b.c("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th3);
                }
                Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                if (!file.delete()) {
                    x5.b.b("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                }
                map2.put(str3, typefaceCreateFromFile);
            } else {
                zipInputStream.closeEntry();
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (jVar == null) {
            return new a0(new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            String str4 = (String) entry.getKey();
            Iterator it = ((HashMap) jVar.c()).values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    xVar = null;
                    break;
                }
                xVar = (x) it.next();
                if (xVar.f7927d.equals(str4)) {
                    break;
                }
            }
            if (xVar != null) {
                Bitmap bitmap = (Bitmap) entry.getValue();
                int i10 = xVar.f7924a;
                int i11 = xVar.f7925b;
                if (bitmap.getWidth() != i10 || bitmap.getHeight() != i11) {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, true);
                    bitmap.recycle();
                    bitmap = bitmapCreateScaledBitmap;
                }
                xVar.f = bitmap;
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            boolean z2 = false;
            for (q5.c cVar : jVar.f.values()) {
                if (cVar.f11001a.equals(entry2.getKey())) {
                    cVar.f11004d = (Typeface) entry2.getValue();
                    z2 = true;
                }
            }
            if (!z2) {
                x5.b.b("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (map.isEmpty()) {
            Iterator it2 = ((HashMap) jVar.c()).entrySet().iterator();
            while (it2.hasNext()) {
                x xVar2 = (x) ((Map.Entry) it2.next()).getValue();
                if (xVar2 == null) {
                    return null;
                }
                String str5 = xVar2.f7927d;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                if (str5.startsWith("data:") && str5.indexOf("base64,") > 0) {
                    try {
                        byte[] bArrDecode = Base64.decode(str5.substring(str5.indexOf(44) + 1), 0);
                        xVar2.f = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                    } catch (IllegalArgumentException e11) {
                        x5.b.c("data URL did not have correct base64 format.", e11);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            q5.g.f11013b.f11014a.k(str, jVar);
        }
        return new a0(jVar);
    }

    public static Boolean h(hf.q qVar, byte[] bArr) {
        try {
            hf.q qVar2 = new hf.q(new hf.o(qVar));
            for (byte b10 : bArr) {
                if (qVar2.readByte() != b10) {
                    return Boolean.FALSE;
                }
            }
            qVar2.close();
            return Boolean.TRUE;
        } catch (Exception unused) {
            x5.b.f14254a.getClass();
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused2) {
            return Boolean.FALSE;
        }
    }

    public static void i() {
        ArrayList arrayList = new ArrayList(f7883b);
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    public static String j(Context context, int i) {
        StringBuilder sb2 = new StringBuilder("rawRes");
        sb2.append((context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_");
        sb2.append(i);
        return sb2.toString();
    }
}
