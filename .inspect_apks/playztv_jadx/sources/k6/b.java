package k6;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import c6.h;
import c6.i;
import c6.j;
import l6.m;
import l6.o;
import l6.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ImageDecoder$OnHeaderDecodedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f7058a = u.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c6.a f7061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f7062e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f7063g;

    public b(int i, int i10, i iVar) {
        this.f7059b = i;
        this.f7060c = i10;
        this.f7061d = (c6.a) iVar.c(o.f);
        this.f7062e = (m) iVar.c(m.f7984g);
        h hVar = o.i;
        this.f = iVar.c(hVar) != null && ((Boolean) iVar.c(hVar)).booleanValue();
        this.f7063g = (j) iVar.c(o.f7987g);
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.f7058a.c(this.f7059b, this.f7060c, this.f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f7061d == c6.a.f2511v) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        Size size = imageInfo.getSize();
        int width = this.f7059b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f7060c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.f7062e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        j jVar = this.f7063g;
        if (jVar != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((jVar == j.f2522u && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i >= 26) {
                ColorSpace.Named unused = ColorSpace.Named.SRGB;
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
