package f2;

import android.media.MediaDrm;
import androidx.media3.decoder.DecoderInputBuffer;
import cc.q0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements MediaDrm.OnEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u5.d f4752b;

    public /* synthetic */ w(u uVar, u5.d dVar, int i) {
        this.f4751a = i;
        this.f4752b = dVar;
    }

    @Override // android.media.MediaDrm.OnEventListener
    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i10, byte[] bArr2) {
        switch (this.f4751a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                q0 q0Var = ((f) this.f4752b.f12784v).Q;
                q0Var.getClass();
                q0Var.obtainMessage(i, bArr).sendToTarget();
                break;
            default:
                q0 q0Var2 = ((f) this.f4752b.f12784v).Q;
                q0Var2.getClass();
                q0Var2.obtainMessage(i, bArr).sendToTarget();
                break;
        }
    }
}
