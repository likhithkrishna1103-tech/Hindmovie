package r5;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;
import o5.f;
import o5.j;
import o5.n;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c3.e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f11518w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i, List list) {
        super(7, list);
        this.f11518w = i;
    }

    @Override // r5.e
    public final o5.e D0() {
        switch (this.f11518w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new f(0, (List) this.f2454v);
            case 1:
                return new j(0, (List) this.f2454v);
            case 2:
                return new f(1, (List) this.f2454v);
            case 3:
                return new j(1, (List) this.f2454v);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return new j(2, (List) this.f2454v);
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return new n((List) this.f2454v);
            default:
                return new f(2, (List) this.f2454v);
        }
    }
}
