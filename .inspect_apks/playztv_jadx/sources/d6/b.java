package d6;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import b1.j;
import com.bumptech.glide.f;
import com.bumptech.glide.load.data.e;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4081u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Comparable f4082v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f4083w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f4084x;

    public /* synthetic */ b(int i, Comparable comparable, Object obj) {
        this.f4081u = i;
        this.f4082v = comparable;
        this.f4083w = obj;
    }

    public static b d(Context context, Uri uri, c cVar) {
        return new b(0, uri, new d(com.bumptech.glide.b.a(context).f2762w.b().f(), cVar, com.bumptech.glide.b.a(context).f2763x, context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f4081u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return InputStream.class;
            case 1:
                ((i6.c) this.f4083w).getClass();
                return InputStream.class;
            default:
                return ((i6.c) this.f4083w).b();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch (this.f4081u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                InputStream inputStream = (InputStream) this.f4084x;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        return;
                    }
                }
                break;
            case 1:
                try {
                    ((ByteArrayInputStream) this.f4084x).close();
                } catch (IOException unused2) {
                    return;
                }
                break;
            default:
                Object obj = this.f4084x;
                if (obj != null) {
                    try {
                        switch (((i6.c) this.f4083w).f6384u) {
                            case j.LONG_FIELD_NUMBER /* 4 */:
                                ((ParcelFileDescriptor) obj).close();
                                break;
                            default:
                                ((InputStream) obj).close();
                                break;
                        }
                    } catch (IOException unused3) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final int c() {
        switch (this.f4081u) {
        }
        return 1;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i = this.f4081u;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(f fVar, com.bumptech.glide.load.data.d dVar) throws Throwable {
        Object objOpen;
        switch (this.f4081u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    InputStream inputStreamI = i();
                    this.f4084x = inputStreamI;
                    dVar.r(inputStreamI);
                } catch (FileNotFoundException e10) {
                    if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e10);
                    }
                    dVar.l(e10);
                    return;
                }
                break;
            case 1:
                try {
                    ByteArrayInputStream byteArrayInputStreamA = i6.c.a((String) this.f4082v);
                    this.f4084x = byteArrayInputStreamA;
                    dVar.r(byteArrayInputStreamA);
                } catch (IllegalArgumentException e11) {
                    dVar.l(e11);
                }
                break;
            default:
                try {
                    i6.c cVar = (i6.c) this.f4083w;
                    File file = (File) this.f4082v;
                    switch (cVar.f6384u) {
                        case j.LONG_FIELD_NUMBER /* 4 */:
                            objOpen = ParcelFileDescriptor.open(file, 268435456);
                            break;
                        default:
                            objOpen = new FileInputStream(file);
                            break;
                    }
                    this.f4084x = objOpen;
                    dVar.r(objOpen);
                } catch (FileNotFoundException e12) {
                    if (Log.isLoggable("FileLoader", 3)) {
                        Log.d("FileLoader", "Failed to open file", e12);
                    }
                    dVar.l(e12);
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
        throw new UnsupportedOperationException("Method not decompiled: d6.b.i():java.io.InputStream");
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
