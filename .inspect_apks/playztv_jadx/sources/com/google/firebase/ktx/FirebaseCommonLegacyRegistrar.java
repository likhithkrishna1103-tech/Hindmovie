package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.bumptech.glide.c;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import na.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Keep
public final class FirebaseCommonLegacyRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b> getComponents() {
        return android.support.v4.media.session.b.G(c.g("fire-core-ktx", "21.0.0"));
    }
}
