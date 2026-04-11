package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import ia.a;
import java.util.Arrays;
import java.util.List;
import ka.b;
import na.c;
import na.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class AbtRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-abt";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a lambda$getComponents$0(c cVar) {
        return new a((Context) cVar.b(Context.class), cVar.e(b.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<na.b> getComponents() {
        na.a aVarA = na.b.a(a.class);
        aVarA.f8873a = LIBRARY_NAME;
        aVarA.a(j.a(Context.class));
        aVarA.a(new j(0, 1, b.class));
        aVarA.f8878g = new ia.b(0);
        return Arrays.asList(aVarA.b(), com.bumptech.glide.c.g(LIBRARY_NAME, "21.1.1"));
    }
}
