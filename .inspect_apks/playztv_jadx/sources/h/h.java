package h;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5499b;

    public h(n.s sVar) {
        this.f5498a = 1;
        this.f5499b = new LinkedHashSet();
        sVar.f("androidx.savedstate.Restarter", this);
    }

    @Override // x4.c
    public final Bundle a() {
        switch (this.f5498a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Bundle bundle = new Bundle();
                ((j) this.f5499b).m().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f5499b));
                return bundle2;
        }
    }

    public h(j jVar) {
        this.f5498a = 0;
        this.f5499b = jVar;
    }
}
