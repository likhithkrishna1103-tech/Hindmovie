package d7;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3469v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Comparable f3470w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f3471x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f3472y;

    public /* synthetic */ f(Comparable comparable, Object obj, int i) {
        this.f3469v = i;
        this.f3470w = comparable;
        this.f3471x = obj;
    }

    public static f c(Context context, Uri uri, y6.b bVar) {
        return new f(uri, new y6.c(com.bumptech.glide.b.a(context).f2195x.b().f(), bVar, com.bumptech.glide.b.a(context).f2196y, context.getContentResolver()), 2);
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f3469v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((c) this.f3471x).getClass();
                return InputStream.class;
            case 1:
                return ((c) this.f3471x).b();
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        switch (this.f3469v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    ((ByteArrayInputStream) this.f3472y).close();
                } catch (IOException unused) {
                    return;
                }
                break;
            case 1:
                Object obj = this.f3472y;
                if (obj != null) {
                    try {
                        switch (((c) this.f3471x).f3458v) {
                            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                ((ParcelFileDescriptor) obj).close();
                                break;
                            default:
                                ((InputStream) obj).close();
                                break;
                        }
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
            default:
                InputStream inputStream = (InputStream) this.f3472y;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        int i = this.f3469v;
    }

    @Override // com.bumptech.glide.load.data.d
    public final int e() {
        switch (this.f3469v) {
        }
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.h hVar, com.bumptech.glide.load.data.c cVar) throws Throwable {
        Object objOpen;
        switch (this.f3469v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    ByteArrayInputStream byteArrayInputStreamA = c.a((String) this.f3470w);
                    this.f3472y = byteArrayInputStreamA;
                    cVar.d(byteArrayInputStreamA);
                } catch (IllegalArgumentException e9) {
                    cVar.c(e9);
                }
                break;
            case 1:
                try {
                    c cVar2 = (c) this.f3471x;
                    File file = (File) this.f3470w;
                    switch (cVar2.f3458v) {
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            objOpen = ParcelFileDescriptor.open(file, 268435456);
                            break;
                        default:
                            objOpen = new FileInputStream(file);
                            break;
                    }
                    this.f3472y = objOpen;
                    cVar.d(objOpen);
                } catch (FileNotFoundException e10) {
                    if (Log.isLoggable("FileLoader", 3)) {
                        Log.d("FileLoader", "Failed to open file", e10);
                    }
                    cVar.c(e10);
                    return;
                }
                break;
            default:
                try {
                    InputStream inputStreamI = i();
                    this.f3472y = inputStreamI;
                    cVar.d(inputStreamI);
                } catch (FileNotFoundException e11) {
                    if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e11);
                    }
                    cVar.c(e11);
                    return;
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0028: MOVE (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:41), block:B:10:0x0028 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream i() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.f.i():java.io.InputStream");
    }

    private final void d() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
