package org.sopt.tree.usage;

import org.sopt.tree.model.Data;

import java.util.ArrayList;

public class Util {

    private static ArrayList<Data> randomized;
    private static ArrayList<Data> fixed;

    public static ArrayList<Data> sample(boolean random) { return random? randomized : fixed; }

    static {


        randomized = new ArrayList<>();

        randomized.add(new Data("Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
        randomized.add(new Data("In eget lacus rhoncus", "In eget lacus rhoncus, facilisis justo ac, venenatis turpis."));
        randomized.add(new Data("Vestibulum aliquet", "Vestibulum aliquet leo sed tellus faucibus, quis feugiat felis lobortis."));
        randomized.add(new Data("Nunc ut augue sit", "Nunc ut augue sit amet leo consectetur volutpat."));
        randomized.add(new Data("Praesent fermentum", "Praesent fermentum ex quis nunc porta, sit amet ultricies justo ultricies."));
        randomized.add(new Data("Morbi vehicula justo", "Morbi vehicula justo aliquam velit lacinia tristique."));
        randomized.add(new Data("Suspendisse varius", "Suspendisse varius orci ullamcorper, porta tellus sed, dignissim diam."));
        randomized.add(new Data("Nunc fermentum arcu", "Nunc fermentum arcu viverra, porta nibh eget, luctus quam."));
        randomized.add(new Data("Nam finibus felis non", "Nam finibus felis non magna scelerisque, eget fringilla nulla scelerisque."));
        randomized.add(new Data("Donec sagittis eros", "Donec sagittis eros quis dui auctor porta."));
        randomized.add(new Data("Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
        randomized.add(new Data("In eget lacus rhoncus", "In eget lacus rhoncus, facilisis justo ac, venenatis turpis."));
        randomized.add(new Data("Vestibulum aliquet", "Vestibulum aliquet leo sed tellus faucibus, quis feugiat felis lobortis."));
        randomized.add(new Data("Nunc ut augue sit", "Nunc ut augue sit amet leo consectetur volutpat."));
        randomized.add(new Data("Praesent fermentum", "Praesent fermentum ex quis nunc porta, sit amet ultricies justo ultricies."));
        randomized.add(new Data("Morbi vehicula justo", "Morbi vehicula justo aliquam velit lacinia tristique."));
        randomized.add(new Data("Suspendisse varius", "Suspendisse varius orci ullamcorper, porta tellus sed, dignissim diam."));
        randomized.add(new Data("Nunc fermentum arcu", "Nunc fermentum arcu viverra, porta nibh eget, luctus quam."));
        randomized.add(new Data("Nam finibus felis non", "Nam finibus felis non magna scelerisque, eget fringilla nulla scelerisque."));
        randomized.add(new Data("Donec sagittis eros", "Donec sagittis eros quis dui auctor porta."));

        fixed = new ArrayList<>();

        fixed.add(new Data(1 , "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
        fixed.add(new Data(38, "In eget lacus rhoncus", "In eget lacus rhoncus, facilisis justo ac, venenatis turpis."));
        fixed.add(new Data(14, "Vestibulum aliquet", "Vestibulum aliquet leo sed tellus faucibus, quis feugiat felis lobortis."));
        fixed.add(new Data(48, "Nunc ut augue sit", "Nunc ut augue sit amet leo consectetur volutpat."));
        fixed.add(new Data(11, "Praesent fermentum", "Praesent fermentum ex quis nunc porta, sit amet ultricies justo ultricies."));

        fixed.add(new Data(49, "Morbi vehicula justo", "Morbi vehicula justo aliquam velit lacinia tristique."));

        fixed.add(new Data(42, "Suspendisse varius", "Suspendisse varius orci ullamcorper, porta tellus sed, dignissim diam."));
        fixed.add(new Data(26, "Nunc fermentum arcu", "Nunc fermentum arcu viverra, porta nibh eget, luctus quam."));

        fixed.add(new Data(27, "Nam finibus felis non", "Nam finibus felis non magna scelerisque, eget fringilla nulla scelerisque."));
        fixed.add(new Data(28, "Donec sagittis eros", "Donec sagittis eros quis dui auctor porta."));

        fixed.add(new Data(24, "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));

        fixed.add(new Data(29, "In eget lacus rhoncus", "In eget lacus rhoncus, facilisis justo ac, venenatis turpis."));

        fixed.add(new Data(25, "Vestibulum aliquet", "Vestibulum aliquet leo sed tellus faucibus, quis feugiat felis lobortis."));
        fixed.add(new Data(2 , "Nunc ut augue sit", "Nunc ut augue sit amet leo consectetur volutpat."));
        fixed.add(new Data(4 , "Praesent fermentum", "Praesent fermentum ex quis nunc porta, sit amet ultricies justo ultricies."));

        fixed.add(new Data(8 , "Morbi vehicula justo", "Morbi vehicula justo aliquam velit lacinia tristique."));

        fixed.add(new Data(5, "Suspendisse varius", "Suspendisse varius orci ullamcorper, porta tellus sed, dignissim diam."));
        fixed.add(new Data(3, "Nunc fermentum arcu", "Nunc fermentum arcu viverra, porta nibh eget, luctus quam."));
        fixed.add(new Data(6, "Nam finibus felis non", "Nam finibus felis non magna scelerisque, eget fringilla nulla scelerisque."));

        fixed.add(new Data(12, "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
        fixed.add(new Data(13, "In eget lacus rhoncus", "In eget lacus rhoncus, facilisis justo ac, venenatis turpis."));

        fixed.add(new Data(100, "Nunc ut augue sit", "Nunc ut augue sit amet leo consectetur volutpat."));
        fixed.add(new Data(92, "Vestibulum aliquet", "Vestibulum aliquet leo sed tellus faucibus, quis feugiat felis lobortis."));

        fixed.add(new Data(70, "Praesent fermentum", "Praesent fermentum ex quis nunc porta, sit amet ultricies justo ultricies."));

        fixed.add(new Data(50, "Morbi vehicula justo", "Morbi vehicula justo aliquam velit lacinia tristique."));
        fixed.add(new Data(51, "Suspendisse varius", "Suspendisse varius orci ullamcorper, porta tellus sed, dignissim diam."));

        fixed.add(new Data(52, "Nunc fermentum arcu", "Nunc fermentum arcu viverra, porta nibh eget, luctus quam."));
        fixed.add(new Data(61, "Nam finibus felis non", "Nam finibus felis non magna scelerisque, eget fringilla nulla scelerisque."));
        fixed.add(new Data(75, "Donec sagittis eros", "Donec sagittis eros quis dui auctor porta."));

        fixed.add(new Data(110, "Donec sagittis eros", "Donec sagittis eros quis dui auctor porta."));

        fixed.add(new Data(78, "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
        fixed.add(new Data(79, "In eget lacus rhoncus", "In eget lacus rhoncus, facilisis justo ac, venenatis turpis."));
        fixed.add(new Data(74, "Vestibulum aliquet", "Vestibulum aliquet leo sed tellus faucibus, quis feugiat felis lobortis."));

        fixed.add(new Data(76, "Nunc ut augue sit", "Nunc ut augue sit amet leo consectetur volutpat."));

        fixed.add(new Data(73, "Praesent fermentum", "Praesent fermentum ex quis nunc porta, sit amet ultricies justo ultricies."));

        fixed.add(new Data(55, "Morbi vehicula justo", "Morbi vehicula justo aliquam velit lacinia tristique."));
    }
}
