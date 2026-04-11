package l6;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements c6.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c6.h f7957v = c6.h.a(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c6.h f7958w = new c6.h("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, c6.h.f2516e);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f6.f f7959u;

    public b(f6.f fVar) {
        this.f7959u = fVar;
    }

    @Override // c6.b
    public final boolean B(Object obj, File file, c6.i iVar) throws Throwable {
        boolean z2;
        Bitmap bitmap = (Bitmap) ((e6.b0) obj).get();
        c6.h hVar = f7958w;
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) iVar.c(hVar);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        int i = x6.h.f14283b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int iIntValue = ((Integer) iVar.c(f7957v)).intValue();
        OutputStream cVar = null;
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                f6.f fVar = this.f7959u;
                if (fVar != null) {
                    try {
                        cVar = new com.bumptech.glide.load.data.c(fileOutputStream, fVar);
                    } catch (IOException e10) {
                        e = e10;
                        cVar = fileOutputStream;
                        if (Log.isLoggable("BitmapEncoder", 3)) {
                            Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                        }
                        if (cVar != null) {
                            try {
                                cVar.close();
                            } catch (IOException unused) {
                            }
                        }
                        z2 = false;
                    } catch (Throwable th) {
                        th = th;
                        cVar = fileOutputStream;
                        if (cVar != null) {
                            try {
                                cVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } else {
                    cVar = fileOutputStream;
                }
                bitmap.compress(compressFormat, iIntValue, cVar);
                cVar.close();
                try {
                    cVar.close();
                } catch (IOException unused3) {
                }
                z2 = true;
            } catch (IOException e11) {
                e = e11;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormat + " of size " + x6.m.c(bitmap) + " in " + x6.h.a(jElapsedRealtimeNanos) + ", options format: " + iVar.c(hVar) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // c6.l
    public final int k(c6.i iVar) {
        return 2;
    }
}
