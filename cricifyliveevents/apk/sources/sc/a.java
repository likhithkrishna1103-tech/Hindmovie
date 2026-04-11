package sc;

import androidx.media3.decoder.DecoderInputBuffer;
import kb.b;
import uc.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f11653v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ b f11654w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ d f11655x;

    public /* synthetic */ a(b bVar, d dVar, int i) {
        this.f11653v = i;
        this.f11654w = bVar;
        this.f11655x = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11653v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f11654w.a(this.f11655x);
                break;
            default:
                this.f11654w.a(this.f11655x);
                break;
        }
    }
}
