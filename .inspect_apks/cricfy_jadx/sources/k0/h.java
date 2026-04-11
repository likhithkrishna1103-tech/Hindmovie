package k0;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f6769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Configuration f6770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6771c;

    public h(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f6769a = colorStateList;
        this.f6770b = configuration;
        this.f6771c = theme == null ? 0 : theme.hashCode();
    }
}
