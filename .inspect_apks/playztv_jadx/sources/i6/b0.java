package i6;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f6382b = new b0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6383a;

    public /* synthetic */ b0(int i) {
        this.f6383a = i;
    }

    @Override // i6.r
    public final q a(Object obj, int i, int i10, c6.i iVar) {
        switch (this.f6383a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new q(new w6.d(obj), new d(1, obj));
            case 1:
                File file = (File) obj;
                return new q(new w6.d(file), new d(0, file));
            default:
                return null;
        }
    }

    @Override // i6.r
    public final boolean b(Object obj) {
        switch (this.f6383a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return true;
            case 1:
                return true;
            default:
                return false;
        }
    }
}
