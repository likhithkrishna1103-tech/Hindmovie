package i6;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements com.bumptech.glide.load.data.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6387u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f6388v;

    public /* synthetic */ d(int i, Object obj) {
        this.f6387u = i;
        this.f6388v = obj;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f6387u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ByteBuffer.class;
            default:
                return this.f6388v.getClass();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        int i = this.f6387u;
    }

    @Override // com.bumptech.glide.load.data.e
    public final int c() {
        switch (this.f6387u) {
        }
        return 1;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i = this.f6387u;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(com.bumptech.glide.f fVar, com.bumptech.glide.load.data.d dVar) {
        switch (this.f6387u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    dVar.r(x6.b.a((File) this.f6388v));
                } catch (IOException e10) {
                    if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                        Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e10);
                    }
                    dVar.l(e10);
                    return;
                }
                break;
            default:
                dVar.r(this.f6388v);
                break;
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
