package ib;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6472a;

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        switch (this.f6472a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                throw new gb.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                gb.e eVar = (gb.e) obj2;
                eVar.g(jb.f.f6927g, entry.getKey());
                eVar.g(jb.f.f6928h, entry.getValue());
                return;
            default:
                throw new gb.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
