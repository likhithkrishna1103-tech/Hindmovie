package me;

import androidx.media3.decoder.DecoderInputBuffer;
import fe.l;
import java.util.Iterator;
import ne.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rd.a f8461c;

    public /* synthetic */ d(Object obj, l lVar, int i) {
        this.f8459a = i;
        this.f8460b = obj;
        this.f8461c = lVar;
    }

    @Override // me.e
    public final Iterator iterator() {
        switch (this.f8459a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new c(this);
            case 1:
                return new j(this);
            default:
                return new ne.b(this);
        }
    }

    public d(CharSequence charSequence, p pVar) {
        this.f8459a = 2;
        ge.i.e(charSequence, "input");
        this.f8460b = charSequence;
        this.f8461c = pVar;
    }
}
