package d7;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3465v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f3466w;

    public /* synthetic */ e(int i, Object obj) {
        this.f3465v = i;
        this.f3466w = obj;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f3465v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ByteBuffer.class;
            default:
                return this.f3466w.getClass();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        int i = this.f3465v;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        int i = this.f3465v;
    }

    @Override // com.bumptech.glide.load.data.d
    public final int e() {
        switch (this.f3465v) {
        }
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.h hVar, com.bumptech.glide.load.data.c cVar) {
        switch (this.f3465v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    cVar.d(s7.b.a((File) this.f3466w));
                } catch (IOException e9) {
                    if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                        Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e9);
                    }
                    cVar.c(e9);
                    return;
                }
                break;
            default:
                cVar.d(this.f3466w);
                break;
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
