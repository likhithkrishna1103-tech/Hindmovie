package ie;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Pattern f6612u;

    public d() {
        Pattern patternCompile = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        be.h.d(patternCompile, "compile(...)");
        this.f6612u = patternCompile;
    }

    public final String toString() {
        String string = this.f6612u.toString();
        be.h.d(string, "toString(...)");
        return string;
    }
}
