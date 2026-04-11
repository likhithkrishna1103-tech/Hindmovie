package m6;

import androidx.media3.decoder.DecoderInputBuffer;
import g1.h;
import j6.j;
import j6.n;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends a7.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f8372x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i, List list) {
        super(4, list);
        this.f8372x = i;
    }

    @Override // m6.f
    public final j6.e D0() {
        switch (this.f8372x) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new j6.f(0, (List) this.f307w);
            case 1:
                return new j(0, (List) this.f307w);
            case 2:
                return new j6.f(1, (List) this.f307w);
            case 3:
                return new j(1, (List) this.f307w);
            case h.LONG_FIELD_NUMBER /* 4 */:
                return new j(2, (List) this.f307w);
            case h.STRING_FIELD_NUMBER /* 5 */:
                return new n((List) this.f307w);
            default:
                return new j6.f(2, (List) this.f307w);
        }
    }
}
