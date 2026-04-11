package d7;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f3467b = new e0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3468a;

    public /* synthetic */ e0(int i) {
        this.f3468a = i;
    }

    @Override // d7.t
    public final s a(Object obj, int i, int i10, x6.h hVar) {
        switch (this.f3468a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new s(new r7.b(obj), new e(1, obj));
            case 1:
                File file = (File) obj;
                return new s(new r7.b(file), new e(0, file));
            default:
                return null;
        }
    }

    @Override // d7.t
    public final boolean b(Object obj) {
        switch (this.f3468a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return true;
            case 1:
                return true;
            default:
                return false;
        }
    }
}
