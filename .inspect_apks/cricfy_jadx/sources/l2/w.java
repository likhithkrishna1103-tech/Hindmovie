package l2;

import android.media.MediaDrm;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements MediaDrm.OnEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p6.c f7685b;

    public /* synthetic */ w(u uVar, p6.c cVar, int i) {
        this.f7684a = i;
        this.f7685b = cVar;
    }

    @Override // android.media.MediaDrm.OnEventListener
    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i10, byte[] bArr2) {
        switch (this.f7684a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h.d dVar = ((f) this.f7685b.f10035w).R;
                dVar.getClass();
                dVar.obtainMessage(i, bArr).sendToTarget();
                break;
            default:
                h.d dVar2 = ((f) this.f7685b.f10035w).R;
                dVar2.getClass();
                dVar2.obtainMessage(i, bArr).sendToTarget();
                break;
        }
    }
}
