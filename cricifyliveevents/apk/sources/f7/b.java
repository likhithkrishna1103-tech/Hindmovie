package f7;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import g7.n;
import g7.p;
import g7.w;
import x6.g;
import x6.h;
import x6.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ImageDecoder$OnHeaderDecodedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f3984a = w.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x6.a f3987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f3988e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f3989g;

    public b(int i, int i10, h hVar) {
        this.f3985b = i;
        this.f3986c = i10;
        this.f3987d = (x6.a) hVar.c(p.f);
        this.f3988e = (n) hVar.c(n.f5200g);
        g gVar = p.i;
        this.f = hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue();
        this.f3989g = (i) hVar.c(p.f5203g);
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.f3984a.c(this.f3985b, this.f3986c, this.f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f3987d == x6.a.f14393w) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        Size size = imageInfo.getSize();
        int width = this.f3985b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f3986c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.f3988e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        i iVar = this.f3989g;
        if (iVar != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((iVar == i.f14404v && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i >= 26) {
                ColorSpace.Named unused = ColorSpace.Named.SRGB;
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
