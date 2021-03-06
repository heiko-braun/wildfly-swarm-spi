/**
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wildfly.swarm.spi.api;

/**
 * @author Bob McWhirter
 */
public interface Fraction {

    interface InitContext {
        void fraction(Fraction fraction);

        void socketBinding(SocketBinding binding);

        void socketBinding(String groupName, SocketBinding binding);

        void outboundSocketBinding(OutboundSocketBinding binding);

        void outboundSocketBinding(String groupName, OutboundSocketBinding binding);
    }

    interface PostInitContext extends InitContext {

        boolean hasFraction(String simpleName);

        Fraction fraction(String simpleName);
    }

    default String simpleName() {
        String name = getClass().getSimpleName();
        if (name.endsWith("Fraction")) {
            name = name.substring(0, name.length() - "Fraction".length());
        }
        return name;
    }

    default void initialize(InitContext initContext) {
        // Do Nothing
    }

    default void postInitialize(PostInitContext initContext) {
        // Do Nothing
    }

}
