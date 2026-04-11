package d7;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3462b;

    public /* synthetic */ d(int i, Object obj) {
        this.f3461a = i;
        this.f3462b = obj;
    }

    @Override // d7.t
    public final s a(Object obj, int i, int i10, x6.h hVar) {
        switch (this.f3461a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                byte[] bArr = (byte[]) obj;
                return new s(new r7.b(bArr), new o(1, bArr, (c) this.f3462b));
            case 1:
                return new s(new r7.b(obj), new f(obj.toString(), (c) this.f3462b, 0));
            case 2:
                File file = (File) obj;
                return new s(new r7.b(file), new f(file, (c) this.f3462b, 1));
            default:
                j jVar = (j) obj;
                return new s(jVar, new w6.a((kf.d) this.f3462b, jVar));
        }
    }

    @Override // d7.t
    public final boolean b(Object obj) {
        switch (this.f3461a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
        return true;
    }
}
