package d7;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String[] f3499y = {"_data"};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3500v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f3501w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f3502x;

    public /* synthetic */ o(int i, Object obj, Object obj2) {
        this.f3500v = i;
        this.f3501w = obj;
        this.f3502x = obj2;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f3500v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return File.class;
            default:
                return ((c) this.f3502x).b();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        int i = this.f3500v;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        int i = this.f3500v;
    }

    @Override // com.bumptech.glide.load.data.d
    public final int e() {
        switch (this.f3500v) {
        }
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.h hVar, com.bumptech.glide.load.data.c cVar) {
        Object objWrap;
        switch (this.f3500v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Cursor cursorQuery = ((Context) this.f3501w).getContentResolver().query((Uri) this.f3502x, f3499y, null, null, null);
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
                    cVar.d(new File(string));
                    return;
                }
                cVar.c(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.f3502x)));
                return;
            default:
                c cVar2 = (c) this.f3502x;
                byte[] bArr = (byte[]) this.f3501w;
                switch (cVar2.f3458v) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        objWrap = ByteBuffer.wrap(bArr);
                        break;
                    default:
                        objWrap = new ByteArrayInputStream(bArr);
                        break;
                }
                cVar.d(objWrap);
                return;
        }
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
