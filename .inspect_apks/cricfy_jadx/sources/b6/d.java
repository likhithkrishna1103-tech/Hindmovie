package b6;

import androidx.media3.decoder.DecoderInputBuffer;
import fe.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1796v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f1797w;

    public /* synthetic */ d(int i, int i10) {
        this.f1796v = i10;
        this.f1797w = i;
    }

    @Override // fe.l
    public final Object a(Object obj) throws Exception {
        c5.c cVarC0;
        switch (this.f1796v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.f1797w;
                cVarC0 = ((c5.a) obj).c0("UPDATE notifications SET opened = ? WHERE id = ?");
                try {
                    cVarC0.e(1, 1);
                    cVarC0.e(2, i);
                    cVarC0.V();
                    return null;
                } finally {
                }
            default:
                int i10 = this.f1797w;
                cVarC0 = ((c5.a) obj).c0("DELETE FROM fav_channels WHERE id = ?");
                try {
                    cVarC0.e(1, i10);
                    cVarC0.V();
                    return null;
                } finally {
                }
        }
    }
}
