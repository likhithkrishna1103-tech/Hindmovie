package h0;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f5594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Configuration f5595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5596c;

    public h(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f5594a = colorStateList;
        this.f5595b = configuration;
        this.f5596c = theme == null ? 0 : theme.hashCode();
    }
}
