package b5;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import h.j;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1784b;

    public b(e eVar) {
        this.f1783a = 0;
        this.f1784b = new LinkedHashSet();
        eVar.f("androidx.savedstate.Restarter", this);
    }

    @Override // b5.d
    public final Bundle a() {
        switch (this.f1783a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f1784b));
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                ((j) this.f1784b).m().getClass();
                return bundle2;
        }
    }

    public b(j jVar) {
        this.f1783a = 1;
        this.f1784b = jVar;
    }
}
