package cc;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2127a;

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        switch (this.f2127a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                throw new ac.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                ac.e eVar = (ac.e) obj2;
                eVar.g(dc.f.f3657g, entry.getKey());
                eVar.g(dc.f.f3658h, entry.getValue());
                return;
            default:
                throw new ac.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
