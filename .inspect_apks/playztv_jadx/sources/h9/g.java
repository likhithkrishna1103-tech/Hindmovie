package h9;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5989e;
    public final /* synthetic */ k f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(k kVar, int i) {
        super(kVar);
        this.f5989e = i;
        this.f = kVar;
    }

    @Override // h9.h
    public final float a() {
        float f;
        float f4;
        switch (this.f5989e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = this.f;
                f = kVar.f6001h;
                f4 = kVar.i;
                break;
            case 1:
                k kVar2 = this.f;
                f = kVar2.f6001h;
                f4 = kVar2.f6002j;
                break;
            default:
                return this.f.f6001h;
        }
        return f + f4;
    }
}
