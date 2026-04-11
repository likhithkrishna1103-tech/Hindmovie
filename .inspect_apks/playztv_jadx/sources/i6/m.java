package i6;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements com.bumptech.glide.load.data.e {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String[] f6412x = {"_data"};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6413u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f6414v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f6415w;

    public /* synthetic */ m(Object obj, int i, Object obj2) {
        this.f6413u = i;
        this.f6414v = obj;
        this.f6415w = obj2;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f6413u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return File.class;
            default:
                return ((c) this.f6415w).b();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        int i = this.f6413u;
    }

    @Override // com.bumptech.glide.load.data.e
    public final int c() {
        switch (this.f6413u) {
        }
        return 1;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i = this.f6413u;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(com.bumptech.glide.f fVar, com.bumptech.glide.load.data.d dVar) {
        Object objWrap;
        switch (this.f6413u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Cursor cursorQuery = ((Context) this.f6414v).getContentResolver().query((Uri) this.f6415w, f6412x, null, null, null);
                if (cursorQuery != null) {
                    try {
                        string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                        cursorQuery.close();
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                    break;
                }
                if (!TextUtils.isEmpty(string)) {
                    dVar.r(new File(string));
                    return;
                }
                dVar.l(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.f6415w)));
                return;
            default:
                c cVar = (c) this.f6415w;
                byte[] bArr = (byte[]) this.f6414v;
                switch (cVar.f6384u) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        objWrap = ByteBuffer.wrap(bArr);
                        break;
                    default:
                        objWrap = new ByteArrayInputStream(bArr);
                        break;
                }
                dVar.r(objWrap);
                return;
        }
    }

    private final void d() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
