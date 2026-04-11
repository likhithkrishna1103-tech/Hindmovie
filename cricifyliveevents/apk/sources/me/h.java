package me;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8467b;

    public /* synthetic */ h(int i, Object obj) {
        this.f8466a = i;
        this.f8467b = obj;
    }

    @Override // me.e
    public final Iterator iterator() {
        switch (this.f8466a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (Iterator) this.f8467b;
            case 1:
                return new ne.c((CharSequence) this.f8467b);
            default:
                return ((Iterable) this.f8467b).iterator();
        }
    }
}
