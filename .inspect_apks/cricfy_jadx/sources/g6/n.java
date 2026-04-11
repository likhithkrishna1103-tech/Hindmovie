package g6;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f5113a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet f5114b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f5115c = {80, 75, 3, 4};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f5116d = {31, -117, 8};

    public static d0 a(final String str, Callable callable, androidx.emoji2.text.w wVar) {
        i iVarA = str == null ? null : l6.g.f7860b.a(str);
        d0 d0Var = iVarA != null ? new d0(iVarA) : null;
        HashMap map = f5113a;
        if (str != null && map.containsKey(str)) {
            d0Var = (d0) map.get(str);
        }
        if (d0Var != null) {
            if (wVar != null) {
                wVar.run();
            }
            return d0Var;
        }
        d0 d0Var2 = new d0(callable, false);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final int i = 0;
            d0Var2.b(new z() { // from class: g6.l
                @Override // g6.z
                public final void onResult(Object obj) {
                    switch (i) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            HashMap map2 = n.f5113a;
                            map2.remove(str);
                            atomicBoolean.set(true);
                            if (map2.size() == 0) {
                                n.j();
                            }
                            break;
                        default:
                            HashMap map3 = n.f5113a;
                            map3.remove(str);
                            atomicBoolean.set(true);
                            if (map3.size() == 0) {
                                n.j();
                            }
                            break;
                    }
                }
            });
            final int i10 = 1;
            d0Var2.a(new z() { // from class: g6.l
                @Override // g6.z
                public final void onResult(Object obj) {
                    switch (i10) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            HashMap map2 = n.f5113a;
                            map2.remove(str);
                            atomicBoolean.set(true);
                            if (map2.size() == 0) {
                                n.j();
                            }
                            break;
                        default:
                            HashMap map3 = n.f5113a;
                            map3.remove(str);
                            atomicBoolean.set(true);
                            if (map3.size() == 0) {
                                n.j();
                            }
                            break;
                    }
                }
            });
            if (!atomicBoolean.get()) {
                map.put(str, d0Var2);
                if (map.size() == 1) {
                    j();
                }
            }
        }
        return d0Var2;
    }

    public static b0 b(Context context, String str, String str2) {
        i iVarA = str2 == null ? null : l6.g.f7860b.a(str2);
        if (iVarA != null) {
            return new b0(iVarA);
        }
        try {
            return c(context, context.getAssets().open(str), str2);
        } catch (IOException e9) {
            return new b0(e9);
        }
    }

    public static b0 c(Context context, InputStream inputStream, String str) {
        i iVarA = str == null ? null : l6.g.f7860b.a(str);
        if (iVarA != null) {
            return new b0(iVarA);
        }
        try {
            ag.q qVarD = vf.g.d(vf.g.Y(inputStream));
            int i = 1;
            if (i(qVarD, f5115c).booleanValue()) {
                return g(context, new ZipInputStream(new ag.d(qVarD, i)), str);
            }
            if (i(qVarD, f5116d).booleanValue()) {
                return d(new GZIPInputStream(new ag.d(qVarD, i)), str);
            }
            String[] strArr = r6.a.f10886z;
            return e(new r6.b(qVarD), str, true);
        } catch (IOException e9) {
            return new b0(e9);
        }
    }

    public static b0 d(InputStream inputStream, String str) {
        ag.q qVarD = vf.g.d(vf.g.Y(inputStream));
        String[] strArr = r6.a.f10886z;
        return e(new r6.b(qVarD), str, true);
    }

    public static b0 e(r6.b bVar, String str, boolean z10) {
        i iVarA;
        try {
            if (str == null) {
                iVarA = null;
            } else {
                try {
                    iVarA = l6.g.f7860b.a(str);
                } catch (Exception e9) {
                    b0 b0Var = new b0(e9);
                    if (z10) {
                        s6.i.b(bVar);
                    }
                    return b0Var;
                }
            }
            if (iVarA != null) {
                b0 b0Var2 = new b0(iVarA);
                if (z10) {
                    s6.i.b(bVar);
                }
                return b0Var2;
            }
            i iVarA2 = q6.s.a(bVar);
            if (str != null) {
                l6.g.f7860b.f7861a.l(str, iVarA2);
            }
            b0 b0Var3 = new b0(iVarA2);
            if (z10) {
                s6.i.b(bVar);
            }
            return b0Var3;
        } catch (Throwable th) {
            if (z10) {
                s6.i.b(bVar);
            }
            throw th;
        }
    }

    public static b0 f(int i, Context context, String str) {
        i iVarA = str == null ? null : l6.g.f7860b.a(str);
        if (iVarA != null) {
            return new b0(iVarA);
        }
        try {
            ag.q qVarD = vf.g.d(vf.g.Y(context.getResources().openRawResource(i)));
            int i10 = 1;
            if (i(qVarD, f5115c).booleanValue()) {
                return g(context, new ZipInputStream(new ag.d(qVarD, i10)), str);
            }
            if (!i(qVarD, f5116d).booleanValue()) {
                String[] strArr = r6.a.f10886z;
                return e(new r6.b(qVarD), str, true);
            }
            try {
                return d(new GZIPInputStream(new ag.d(qVarD, i10)), str);
            } catch (IOException e9) {
                return new b0(e9);
            }
        } catch (Resources.NotFoundException e10) {
            return new b0(e10);
        }
    }

    public static b0 g(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return h(context, zipInputStream, str);
        } finally {
            s6.i.b(zipInputStream);
        }
    }

    public static b0 h(Context context, ZipInputStream zipInputStream, String str) {
        i iVarA;
        y yVar;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (str == null) {
            iVarA = null;
        } else {
            try {
                iVarA = l6.g.f7860b.a(str);
            } catch (IOException e9) {
                return new b0(e9);
            }
        }
        if (iVarA != null) {
            return new b0(iVarA);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        i iVar = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                ag.q qVarD = vf.g.d(vf.g.Y(zipInputStream));
                String[] strArr = r6.a.f10886z;
                iVar = e(new r6.b(qVarD), null, false).f5057a;
            } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                String[] strArrSplit = name.split("/");
                map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
            } else if (name.contains(".ttf") || name.contains(".otf")) {
                String[] strArrSplit2 = name.split("/");
                String str2 = strArrSplit2[strArrSplit2.length - 1];
                String str3 = str2.split("\\.")[0];
                if (context == null) {
                    return new b0(new IllegalStateException("Unable to extract font " + str3 + " please pass a non-null Context parameter"));
                }
                File file = new File(context.getCacheDir(), str2);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } finally {
                    }
                } catch (Throwable th3) {
                    s6.c.c("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th3);
                }
                Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                if (!file.delete()) {
                    s6.c.b("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                }
                map2.put(str3, typefaceCreateFromFile);
            } else {
                zipInputStream.closeEntry();
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (iVar == null) {
            return new b0(new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            String str4 = (String) entry.getKey();
            Iterator it = ((HashMap) iVar.c()).values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    yVar = null;
                    break;
                }
                yVar = (y) it.next();
                if (yVar.f5162d.equals(str4)) {
                    break;
                }
            }
            if (yVar != null) {
                yVar.f = s6.i.d((Bitmap) entry.getValue(), yVar.f5159a, yVar.f5160b);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            boolean z10 = false;
            for (l6.c cVar : iVar.f.values()) {
                if (cVar.f7848a.equals(entry2.getKey())) {
                    cVar.f7851d = (Typeface) entry2.getValue();
                    z10 = true;
                }
            }
            if (!z10) {
                s6.c.b("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (map.isEmpty()) {
            Iterator it2 = ((HashMap) iVar.c()).entrySet().iterator();
            while (it2.hasNext()) {
                y yVar2 = (y) ((Map.Entry) it2.next()).getValue();
                if (yVar2 == null) {
                    return null;
                }
                String str5 = yVar2.f5162d;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                if (str5.startsWith("data:") && str5.indexOf("base64,") > 0) {
                    try {
                        byte[] bArrDecode = Base64.decode(str5.substring(str5.indexOf(44) + 1), 0);
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                        if (bitmapDecodeByteArray != null) {
                            yVar2.f = s6.i.d(bitmapDecodeByteArray, yVar2.f5159a, yVar2.f5160b);
                        }
                    } catch (IllegalArgumentException e10) {
                        s6.c.c("data URL did not have correct base64 format.", e10);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            l6.g.f7860b.f7861a.l(str, iVar);
        }
        return new b0(iVar);
    }

    public static Boolean i(ag.q qVar, byte[] bArr) {
        try {
            ag.q qVarD = vf.g.d(new ag.n(qVar));
            for (byte b8 : bArr) {
                if (qVarD.readByte() != b8) {
                    return Boolean.FALSE;
                }
            }
            qVarD.close();
            return Boolean.TRUE;
        } catch (Exception unused) {
            s6.c.f11547a.getClass();
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused2) {
            return Boolean.FALSE;
        }
    }

    public static void j() {
        ArrayList arrayList = new ArrayList(f5114b);
        if (arrayList.size() > 0) {
            throw q4.a.k(0, arrayList);
        }
    }

    public static String k(Context context, int i) {
        StringBuilder sb = new StringBuilder("rawRes");
        sb.append((context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }
}
