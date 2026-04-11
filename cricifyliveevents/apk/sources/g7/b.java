package g7;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements x6.k {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final x6.g f5169w = x6.g.a(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final x6.g f5170x = new x6.g("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, x6.g.f14398e);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a7.g f5171v;

    public b(a7.g gVar) {
        this.f5171v = gVar;
    }

    @Override // x6.k
    public final int l(x6.h hVar) {
        return 2;
    }

    @Override // x6.b
    public final boolean m(Object obj, File file, x6.h hVar) throws Throwable {
        boolean z10;
        Bitmap bitmap = (Bitmap) ((z6.b0) obj).get();
        x6.g gVar = f5170x;
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) hVar.c(gVar);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        int i = s7.h.f11599b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int iIntValue = ((Integer) hVar.c(f5169w)).intValue();
        OutputStream bVar = null;
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                a7.g gVar2 = this.f5171v;
                if (gVar2 != null) {
                    try {
                        bVar = new com.bumptech.glide.load.data.b(fileOutputStream, gVar2);
                    } catch (IOException e9) {
                        e = e9;
                        bVar = fileOutputStream;
                        if (Log.isLoggable("BitmapEncoder", 3)) {
                            Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                        }
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException unused) {
                            }
                        }
                        z10 = false;
                    } catch (Throwable th) {
                        th = th;
                        bVar = fileOutputStream;
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } else {
                    bVar = fileOutputStream;
                }
                bitmap.compress(compressFormat, iIntValue, bVar);
                bVar.close();
                try {
                    bVar.close();
                } catch (IOException unused3) {
                }
                z10 = true;
            } catch (IOException e10) {
                e = e10;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormat + " of size " + s7.m.c(bitmap) + " in " + s7.h.a(jElapsedRealtimeNanos) + ", options format: " + hVar.c(gVar) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z10;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
